package com.interview.mvc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.interview.mvc.model.WebSite;

@Repository
public class WebSiteStatusRepo {

	@Autowired
	private JdbcTemplate template;

	public List<WebSite> getWebSites() {

		String sql = "SELECT * FROM WEBSITE_STATUS;";

		return template.query(sql, new RowMapper<WebSite>() {
			@Override
			public WebSite mapRow(ResultSet rs, int rowNum) throws SQLException {
				WebSite dto = new WebSite();

				dto.setSite(rs.getString(2));

				return dto;
			}
		});
	}

	
	public int addSite(String site) {

		String sql = "INSERT INTO WEBSITE_STATUS(SITE) VALUES(?)";

		return template.update(sql, site);
	}

}
