package com.interview.mvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.interview.mvc.model.TableItem;
import com.interview.mvc.model.TableItemForm;
import com.interview.mvc.repo.TableInfoRepo;

@Controller
public class TableListController {

	@Autowired
	private TableInfoRepo infoRepo;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@PostMapping("/list")
	public ModelAndView getList(@RequestParam("tableName") String tableName,
			@RequestParam("UniqueCol") String uniqueCol, @RequestParam("ColName") String colName) {

		System.out.println(tableName);
		System.out.println(uniqueCol);
		System.out.println(colName);

		StringBuffer br = new StringBuffer();
		br.append("SELECT * ").append("FROM ").append(tableName).append(";");
		System.out.println(br.toString());
		List<TableItem> list = infoRepo.getInfo(br.toString(), tableName);
		System.out.println(list);

		ModelAndView mv = new ModelAndView();
		TableItemForm tableItemForm = new TableItemForm();
		tableItemForm.setItems(list.stream()
                .distinct()
                .collect(Collectors.toList()));

		mv.setViewName("list");
		mv.addObject("tableItems", tableItemForm);

		return mv;
	}

	@PostMapping(value = "/save")
	public ModelAndView save(@ModelAttribute("tableItem") TableItemForm tableItems,RedirectAttributes redirectAttributes) {
		System.out.println(tableItems);

		List<TableItem> list = tableItems.getItems();

		if (null != list && list.size() > 0) {

			for (TableItem tableItem : list) {

				if (tableItem.getUpdateValue() != null && !tableItem.getUpdateValue().isEmpty() ) {
					int i = infoRepo.update(tableItem);

					if (i == 1) {

						System.out.println("updated");
					}
				}
			}
		}
		StringBuffer br = new StringBuffer();
		br.append("SELECT * ").append("FROM ").append(list.get(0).getTableName()).append(";");
		
		ModelAndView mv = new ModelAndView();
		TableItemForm tableItemForm = new TableItemForm();
		tableItemForm.setItems(infoRepo.getInfo(br.toString(), list.get(0).getTableName()).stream()
                .distinct()
                .collect(Collectors.toList()));

		mv.setViewName("list");
		mv.addObject("tableItems", tableItemForm);

		return mv;
	}
	
}
