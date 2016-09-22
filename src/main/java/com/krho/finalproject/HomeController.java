package com.krho.finalproject;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.evdb.javaapi.data.Event;

import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("activityQuery")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/fireBase")
	public String googleLogin() {
		return "fireBase";
	}
	
	@RequestMapping(value="/concerts")
	public String eventfulConcerts(Model model) {
		List <Event> result = Eventful.search("Detroit", "2016092300-2016092523", "concert", 20, 1);
		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/festivals")
	public String eventfulFestivals(Model model) {
		List <Event> result = Eventful.search("Detroit", "2016092300-2016092523", "festival", 20, 1);
		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/sports")
	public String eventfulSports(Model model) {
		List <Event> result = Eventful.search("Detroit", "2016092300-2016092523", "sport", 20, 1);
		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/movieshowtimes")
	public String movieshowtimes(Model model) throws IOException {
		MovieList result = MovieController.getMovieList();
		List <Movie> movies = result.getMovie();
		model.addAttribute("movies", movies);
		return "movieshowtimes";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
		User user = new User();
		model.put("userForm", user);
		return "login";
	}
	
	@RequestMapping(value = "/querystart", method = RequestMethod.GET)
	public ModelAndView startQuery (@ModelAttribute("userForm") User userForm, 
									Map<String, Object> model) {
//		ActivityQuery actQuery = ActivityQuery.getInstance();
		ActivityQuery actQuery = new ActivityQuery();
		
		model.put("activityQuery", actQuery);
		
		return new ModelAndView("querystart","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer1", method = RequestMethod.POST)
	public ModelAndView query2 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		
		return new ModelAndView("query2","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer2", method = RequestMethod.POST)
	public ModelAndView query3 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query3","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer3", method = RequestMethod.POST)
	public ModelAndView query4 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query4","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer4", method = RequestMethod.POST)
	public ModelAndView query5 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query5","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer5", method = RequestMethod.POST)
	public ModelAndView finalResults (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		
		QueryBuilder buildQ = new QueryBuilder(actQuery);
		System.out.println(buildQ.buildQuery());
		List <Activity> activities = DAO.getActivities(buildQ.buildQuery());

//		return new ModelAndView("results","finalQuery", buildQ.buildQuery());		
		return new ModelAndView("results","finalQuery", activities);
	}
}
