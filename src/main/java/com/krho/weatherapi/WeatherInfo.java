package com.krho.weatherapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krho.secret.APIConfigurationSettings;

public class WeatherInfo {
	
	private WeatherDetails inCity;
	
	
	
	public WeatherInfo(String zipcode) {
		setup(zipcode);
	}

	private WeatherDetails setup(String zipCode){
		inCity=null; 
		URL url =null;
		String apiKey = APIConfigurationSettings.WeatherAPIKey;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?zip="+ zipCode +",us&appid=" + apiKey);
			ObjectMapper mapper = new ObjectMapper();
			inCity = mapper.readValue(url, WeatherDetails.class);
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return inCity;
	}
	
	//private static WeatherDetails weather = setup(zipCode); 
	
	public String getIcon(){
				
		return inCity.getWeather().get(0).getIcon();
	}
	
	public String getCityName(){
		return inCity.getName();
	}
	
	public String getWeatherDescription(){
		return inCity.getWeather().get(0).getDescription();
	}
	
	public String getWeatherInF(){
		double tempInKelven = inCity.getMain().getTemp();
		double tempInF = tempInKelven * 9/5 - 459.67;
		BigDecimal temp = new BigDecimal(tempInF);
		
		return temp.setScale(0, BigDecimal.ROUND_CEILING).toString() + "&#8457";
	}
	
	public String getHighTemp(){
		
		double tempInKelven = inCity.getMain().getTempMax();
		double tempInF = tempInKelven * 9/5 - 459.67;
		BigDecimal temp = new BigDecimal(tempInF);
		
		return temp.setScale(0, BigDecimal.ROUND_CEILING).toString() + "&#8457";
	}
	
public String getLowTemp(){
		
		double tempInKelven = inCity.getMain().getTempMin();
		double tempInF = tempInKelven * 9/5 - 459.67;
		BigDecimal temp = new BigDecimal(tempInF);
		
		return temp.setScale(0, BigDecimal.ROUND_CEILING).toString() + "&#8457";
	}

public double getWindSpeed(){
	return inCity.getWind().getSpeed(); 
	}

public double Cloud(){
	return inCity.getClouds().getAll();
}

}
