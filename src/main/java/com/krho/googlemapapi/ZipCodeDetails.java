package com.krho.googlemapapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ZipCodeDetails {

	public static String getCityName(String zipCode){
	URL url =null;
	String cityName = ""; 
	try {
		url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode + "&sensor=true");
		ObjectMapper mapper = new ObjectMapper();
		ZipCode toCityName = mapper.readValue(url, ZipCode.class);
		cityName = toCityName.getResults().get(0).getAddressComponents().get(1).getLongName();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(cityName); // for test on console 
	return cityName;
	}
}
