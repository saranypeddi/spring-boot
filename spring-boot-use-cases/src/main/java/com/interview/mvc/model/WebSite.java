package com.interview.mvc.model;

public class WebSite {
	private String site;

	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "WebSite [site=" + site + ", status=" + status + "]";
	}
	
	
}
