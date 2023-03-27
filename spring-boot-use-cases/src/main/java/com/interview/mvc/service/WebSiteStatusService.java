package com.interview.mvc.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.mvc.model.WebSite;
import com.interview.mvc.repo.WebSiteStatusRepo;

@Service
public class WebSiteStatusService {
	
	@Autowired
	private WebSiteStatusRepo repo;
	
	public List<WebSite> getStatus() throws URISyntaxException, MalformedURLException {
		
		
		List<WebSite> list = repo.getWebSites();
		List<WebSite> sites = new ArrayList<>();
		
		 URI uri = null;
		 URL url = null;
		for(WebSite site : list) {
			
		   if(!site.getSite().contains("https://")) {
			   
			  uri  = new URI("https://"+site.getSite());
		   }
		   else {
			   uri  = new URI(site.getSite());
		   }
		   
			  
			   url = uri.toURL();
				
				if(isSiteUp(url)){
					WebSite site1 = new WebSite();
					site1.setSite(site.getSite());
					site1.setStatus("up");
					System.out.print(site1);
					sites.add(site1);
				}
				
		   
			
		}
		
		return sites;
		
	}

	
	public static boolean isSiteUp(URL site) {
        try {
        	
        	System.out.println(site.toString());
            HttpURLConnection conn = (HttpURLConnection) site.openConnection();
            conn.getContent();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException tout) {
            return false;
        } catch (IOException ioex) {
           
            return false;
        }
      }
	
	public void addSite(String url)
	{
		repo.addSite(url);
	}
	
	public List<WebSite> getSites()
	{
		return repo.getWebSites();
	}
}
