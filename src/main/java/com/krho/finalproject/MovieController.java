package com.krho.finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.evdb.javaapi.APIConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krho.secret.APIConfigurationSettings;


public class MovieController {
	
	public static String httpGet(String urlStr) throws IOException {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
			  System.out.println("there is error != 200");
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  
		  return sb.toString();
		}
	
	public static MovieList getMovieList(String zip) throws IOException {
		
		// get JSON result from the API and provide some custom parameters 
		String movieJason = "{\"movie\":" + MovieController.httpGet("http://data.tmsapi.com/v1.1/movies/showings?startDate="+ APISetDate.TODAY + "&zip="+ zip +"&api_key=" + APIConfigurationSettings.KEY_ID) + "}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		MovieList emp = mapper.readValue(movieJason, MovieList.class);	
		
		
//		// print the movie show times results in console 
//		for (int i=0; i < emp.getMovie().size(); i++){
//		System.out.println("Title: " + emp.getMovie().get(i).getTitle());
//		System.out.println("Release Date: " + emp.getMovie().get(i).getReleaseDate());
//		System.out.println("Description: \n" + emp.getMovie().get(i).getLongDescription());
//		System.out.println("Genres: " + emp.getMovie().get(i).getGenres());
//		System.out.println("Top Cast" + emp.getMovie().get(i).getTopCast());
//		System.out.println("Official URL: " + emp.getMovie().get(i).getOfficialUrl());
//		System.out.println("Showtimes: \n" + emp.getMovie().get(i).getShowtimes());
//		}
		
		return emp;
	}
}
