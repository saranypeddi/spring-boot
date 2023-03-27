package com.interview.mvc.repo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.interview.mvc.model.TableItem;

@Repository
public class TableInfoRepo {

	@Autowired
	private JdbcTemplate template;

	public List<TableItem> getInfo(String sql, String tableName) {

		return template.query(sql, new ResultSetExtractor<List<TableItem>>() {
			@Override
			public List<TableItem> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<TableItem> list = new ArrayList<>();
				TableItem item = null;
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				while (rs.next()) {
					item = new TableItem();
					item.setColValue(rs.getString(2));

					for (int i = 1; i <= columnCount; i++) {
						item.setColName(rsmd.getColumnName(i).toLowerCase());
						item.setIsAutoInc(rsmd.isAutoIncrement(i));
						item.setColType(rsmd.getColumnTypeName(i));

						item.setTableName(tableName.toLowerCase());

					}
					list.add(item);
				}

				return list;
			}
		});

	}

	public int update(TableItem item) {

		String SQL = "update " + item.getTableName() + " set " + item.getColName() + " = ? where " + item.getColName()
				+ "= ?";

		return template.update(SQL, item.getUpdateValue(), item.getColValue());

	}

}
