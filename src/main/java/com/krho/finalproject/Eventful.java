package com.krho.finalproject;

import com.evdb.javaapi.data.request.SearchRequest;
import com.evdb.javaapi.operations.EventOperations;
import com.krho.secret.APIConfigurationSettings;

import java.util.Arrays;
import java.util.List;

import com.evdb.javaapi.APIConfiguration;
import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.data.SearchResult;
import com.evdb.javaapi.data.request.EventSearchRequest;


public class Eventful {
	private static EventSearchRequest esr = null;
	private static EventOperations eo = null;
	private static APIConfiguration api = null;
	
	public static void setup() {
		eo = new EventOperations();
		esr = new EventSearchRequest();
		api = new APIConfiguration();
		
		api.setApiKey(APIConfigurationSettings.apiKey);
		api.setEvdbUser(APIConfigurationSettings.user);
		api.setEvdbPassword(APIConfigurationSettings.password);
	}
	
	public static List<Event> search (String loc, String dates, String keywords, int pageSize, int pageNumber) {
		if (api == null)
			setup();
		esr.setLocation(loc);
		esr.setDateRange(dates);
		esr.setPageSize(pageSize);
		esr.setPageNumber(pageNumber);
		esr.setKeywords(keywords);
//		esr.setCategory(category);
		// These 2 lines will set the timeout to 60 seconds.Normally not needed
		// Unless you are using Google App Engine
		esr.setConnectionTimeout(60000);  // Used with Google App Engine only
		esr.setReadTimeout(60000);        // Used with Google App Engine only
		SearchResult sr = null;
		List<Event> events = null;
		try {
		        sr = eo.search(esr);
		        if (sr.getTotalItems() > 1) {
		        	events = sr.getEvents();
	    		   }
		}catch(Exception var){
	        System.out.println("Oops got runtime an error: "+ var);
		} 
		return events;
	}
	
	
	
}
