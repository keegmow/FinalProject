package com.krho.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class Movie {

private String title;
private String releaseDate;
private List<String> genres = new ArrayList<String>();
private String longDescription;
private List<String> topCast = new ArrayList<String>();
private String officialUrl;
private List<Showtime> showtimes = new ArrayList<Showtime>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The title
*/
public String getTitle() {
return title;
}

/**
*
* @param title
* The title
*/
public void setTitle(String title) {
this.title = title;
}

/**
*
* @return
* The releaseDate
*/
public String getReleaseDate() {
return releaseDate;
}

/**
*
* @param releaseDate
* The releaseDate
*/
public void setReleaseDate(String releaseDate) {
this.releaseDate = releaseDate;
}

/**
*
* @return
* The genres
*/
public List<String> getGenres() {
return genres;
}

/**
*
* @param genres
* The genres
*/
public void setGenres(List<String> genres) {
this.genres = genres;
}

/**
*
* @return
* The longDescription
*/
public String getLongDescription() {
return longDescription;
}

/**
*
* @param longDescription
* The longDescription
*/
public void setLongDescription(String longDescription) {
this.longDescription = longDescription;
}

/**
*
* @return
* The topCast
*/
public List<String> getTopCast() {
return topCast;
}

/**
*
* @param topCast
* The topCast
*/
public void setTopCast(List<String> topCast) {
this.topCast = topCast;
}

/**
*
* @return
* The officialUrl
*/
public String getOfficialUrl() {
return officialUrl;
}

/**
*
* @param officialUrl
* The officialUrl
*/
public void setOfficialUrl(String officialUrl) {
this.officialUrl = officialUrl;
}

/**
*
* @return
* The showtimes
*/
public List<Showtime> getShowtimes() {
return showtimes;
}

/**
*
* @param showtimes
* The showtimes
*/
public void setShowtimes(List<Showtime> showtimes) {
this.showtimes = showtimes;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}