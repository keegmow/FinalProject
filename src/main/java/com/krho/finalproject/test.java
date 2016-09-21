package com.krho.finalproject;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	public static void main(String[] args) throws IOException {
		
		// get JSON result from the API and provide some custom parameters 
		String movieJason = "{\"movie\":" + MovieController.httpGet("http://data.tmsapi.com/v1.1/movies/showings?startDate="+ Key.TODAY + "&zip="+ Key.ZIPCODE +"&api_key=" + Key.KEY_ID) + "}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		MovieList emp = mapper.readValue(movieJason, MovieList.class);	
		
		// print the movie show times results in console 
		for (int i=0; i < emp.getMovie().size(); i++){
		System.out.println("Title: " + emp.getMovie().get(i).getTitle());
		System.out.println("Release Date: " + emp.getMovie().get(i).getReleaseDate());
		System.out.println("Description: \n" + emp.getMovie().get(i).getLongDescription());
		System.out.println("Genres: " + emp.getMovie().get(i).getGenres());
		System.out.println("Top Cast" + emp.getMovie().get(i).getTopCast());
		System.out.println("Official URL: " + emp.getMovie().get(i).getOfficialUrl());
		System.out.println("Showtimes: \n" + emp.getMovie().get(i).getShowtimes());
		}
		
	}

}
