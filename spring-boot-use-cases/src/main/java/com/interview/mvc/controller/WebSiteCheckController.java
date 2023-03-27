package com.interview.mvc.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.interview.mvc.model.WebSite;
import com.interview.mvc.model.WebSiteDTO;
import com.interview.mvc.service.WebSiteStatusService;

@Controller
public class WebSiteCheckController {

	@Autowired
	private WebSiteStatusService service;

	@PostMapping("/addSite")
	public ModelAndView add(@RequestParam("site") String site) {

		WebSiteDTO dto = null;
		service.addSite(site);

		ModelAndView mv = new ModelAndView();

		List<WebSite> list;
		try {
			list = service.getStatus();

			dto = new WebSiteDTO();

			dto.setSites(list);
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}

		mv.setViewName("website");
		mv.addObject("websites", dto);

		return mv;
	}

	@GetMapping("/status")
	public ModelAndView getList() {
		WebSiteDTO dto = null;
		System.out.println("in list");
		ModelAndView mv = new ModelAndView();

		List<WebSite> list;
		try {
			list = service.getStatus();

			dto = new WebSiteDTO();

			dto.setSites(list);
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}

		mv.setViewName("website");
		mv.addObject("websites", dto);

		return mv;
	}

}
