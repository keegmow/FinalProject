package com.krho.weatherapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krho.secret.APIConfigurationSettings;

public class WeatherAPITest {

	public static void main(String[] args) {

		URL url =null;
		//String weatherInCity = ""; 
		String zipCode = "48310"; 
		String apiKey = APIConfigurationSettings.WeatherAPIKey;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?zip="+ zipCode +",us&appid=" + apiKey);
			ObjectMapper mapper = new ObjectMapper();
			WeatherDetails inCity = mapper.readValue(url, WeatherDetails.class);
			//weatherInCity = inCity.getWeather().size();
			double tempInKelven = inCity.getMain().getTemp();
			double tempInF = tempInKelven * 9/5 - 459.67;
			BigDecimal temp = new BigDecimal(tempInF);
			System.out.println("the tempreture is: " + temp.setScale(0, BigDecimal.ROUND_CEILING).toString() + "F"); // for test on console 
			System.out.println("the image icon is" + inCity.getWeather().get(0).getIcon());
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
	}

}
