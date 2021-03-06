package com.krho.finalproject;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class Showtime {

private Theatre theatre;
private String dateTime;
private String quals;
private Boolean barg;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The theatre
*/
public Theatre getTheatre() {
return theatre;
}

/**
*
* @param theatre
* The theatre
*/
public void setTheatre(Theatre theatre) {
this.theatre = theatre;
}

/**
*
* @return
* The dateTime
*/
public String getDateTime() {
return dateTime.substring(dateTime.indexOf('T')+1);
}

public String getTheatreName() {
	return theatre.toString();
}




/**
*
* @param dateTime
* The dateTime
*/
public void setDateTime(String dateTime) {
this.dateTime = dateTime;
}

/**
*
* @return
* The quals
*/
public String getQuals() {
return quals;
}

/**
*
* @param quals
* The quals
*/
public void setQuals(String quals) {
this.quals = quals;
}

/**
*
* @return
* The barg
*/
public Boolean getBarg() {
return barg;
}

/**
*
* @param barg
* The barg
*/
public void setBarg(Boolean barg) {
this.barg = barg;
}

@Override 
public String toString(){
	return "Time: " + dateTime.substring(dateTime.indexOf('T')+1) + " " + this.theatre.toString();
}

//public String toString(){
//	String theatreName = "";
//	String showtimesString = "";
//	
//	for(int i = 0; i<)
//		if(theatreName.isEmpty()) {
//			theatreName = this.theatre.toString();
//			showtimesString = theatreName + ": ";
//		}else if (theatreName.equalsIgnoreCase(this.theatre.toString())) {
//			showtimesString = dateTime.substring(dateTime.indexOf('T')+1) + ", ";
//		} else {
//			showtimesString += "";
//			theatreName = "";
//		}
//	return showtimesString;
//}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}