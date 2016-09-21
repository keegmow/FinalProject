package com.krho.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MovieList {

private List<Movie> movie = new ArrayList<Movie>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The movie
*/
public List<Movie> getMovie() {
return movie;
}

/**
*
* @param movie
* The Movie
*/
public void setMovie(List<Movie> movie) {
this.movie = movie;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}