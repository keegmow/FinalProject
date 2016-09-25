package com.krho.finalproject;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.evdb.javaapi.data.Event;

import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes({"activityQuery", "userloggedin"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate);
//		
//		return "home";
//	}
	
	Question quest = new Question();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Map <String, Object> model) {
		String userloggedin = "false";
		model.put("userloggedin", userloggedin);
		return new ModelAndView("home", "userloggedin", userloggedin);
	}
	
//	@RequestMapping(value = "/fireBase", method = RequestMethod.GET)
////	public String googleLogin(HttpServletResponse response, @CookieValue("foo") String fooCookie, @RequestParam(value = "loggedIn", defaultValue = "false", required = false) String loggedIn) {
//	public ModelAndView googleLogin(@RequestParam(value = "loggedIn", required = false) String loggedIn, @ModelAttribute("userloggedin") String userattribute) {
//		//check if user is logged in
//		if(userattribute != null){
//			if(!userattribute.equalsIgnoreCase("false")){
//				return new ModelAndView("redirect:/querystart", "userloggedin", userattribute);
//			}
//		}
//		
//		System.out.println("deBug: " + loggedIn);
//		loggedIn = "false";
//		return new ModelAndView("fireBase","userloggedin", loggedIn);
//	}
	@RequestMapping(value = "/fireBase")
	public ModelAndView googleLogin(@ModelAttribute("userloggedin") String userLogged, @RequestParam(value="loggedIn", defaultValue="false", required=false) String loggedIn) {
		if (!loggedIn.equals("false")) {
			userLogged = loggedIn;
		}
		System.out.println("loggedIn: " + loggedIn);
		System.out.println("userLogged: " + userLogged);
		if (userLogged.equals("false")) {
			return new ModelAndView("fireBase");			
		} else {
			return new ModelAndView("location", "userloggedin", userLogged);
		}
		
	}
	
	@RequestMapping(value="location")
	public ModelAndView enterZipcode( Map<String,Object> model, @ModelAttribute("userloggedin") String displayName) {
		
		ActivityQuery actQuery = new ActivityQuery();
		
		actQuery.setDisplayName(displayName);
		
		model.put("activityQuery", actQuery);
		
		return new ModelAndView("location", "activityQuery", actQuery);
	}
	
	@RequestMapping(value="/concerts")
	public String eventfulConcerts(Model model) {

		List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23", "concert", 20, 1);

		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/festivals")
	public String eventfulFestivals(Model model) {

		List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23", "festival", 20, 1);

		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/sports")
	public String eventfulSports(Model model) {

		List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23", "sport", 20, 1);

		model.addAttribute("results", result);
//		for(Event e : result){
//			System.out.println(e.getTitle());
//		}
		return "eventfulResults";
	}
	
	@RequestMapping(value="/movieshowtimes")
	public String movieshowtimes(@ModelAttribute("activityQuery") ActivityQuery actQuery ,Model model) throws IOException {
		MovieList result = MovieController.getMovieList(actQuery.getZipcode());
		
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
	
	@RequestMapping(value = "/zipcode", method = RequestMethod.GET)
	public ModelAndView startQuery (@ModelAttribute("userForm") User userForm,
									@Valid @ModelAttribute("activityQuery") ActivityQuery actQuery,
									BindingResult result,
									Map<String, Object> model) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return new ModelAndView("location");
        }
		
		return new ModelAndView("querystart","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer1", method = RequestMethod.GET)
	public ModelAndView query2 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		
		if (actQuery.getAnswer1().equals(quest.supriseMe)) {
			ModelAndView suprise = finalResults(actQuery, model);
			return suprise;
		} else if (actQuery.getAnswer1().equals(quest.choice1a)) {
			return new ModelAndView("query3","activityQuery", actQuery);
		} else {
			return new ModelAndView("query2","activityQuery", actQuery);
		}
	}
	
	@RequestMapping(value = "/answer2", method = RequestMethod.GET)
	public ModelAndView query3 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query3","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer3", method = RequestMethod.GET)
	public ModelAndView query4 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query4","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer4", method = RequestMethod.GET)
	public ModelAndView query5 (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {
		return new ModelAndView("query5","activityQuery", actQuery);
	}
	
	@RequestMapping(value = "/answer5", method = RequestMethod.GET)
	public ModelAndView finalResults (@ModelAttribute("activityQuery") ActivityQuery actQuery,
									Map<String, Object> model) {

		
		Activity activity = new Activity();
//		System.out.println(activity.buildQuery(actQuery));
		List <Activity> activities = DAO.getActivities(activity.buildQuery(actQuery));
		
		Collections.shuffle(activities);
	
		return new ModelAndView("results","finalQuery", activities);
	}
	
	 @RequestMapping(value = "/redirect", method = RequestMethod.GET)
	    public ModelAndView method() {
		 String projectUrl = "https://www.google.com/#q=" ;
	            return new ModelAndView("redirect:" + projectUrl);

	    }
	
	@RequestMapping(value = "activityChoice")
	public ModelAndView activityChoice (@RequestParam(value="activityParam")String activity,@ModelAttribute("activityQuery") ActivityQuery actQuery, Model model) throws IOException {
		if (activity.equalsIgnoreCase("Movie Theater")) {
			MovieList result = MovieController.getMovieList(actQuery.getZipcode());
			List <Movie> movies = result.getMovie();
			model.addAttribute("movies", movies);
			return new ModelAndView("movieshowtimes");
		} else if (activity.equalsIgnoreCase("Festival")) {
			List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23","festival", 20, 1);
			model.addAttribute("results", result);
			return new ModelAndView("eventfulResults");
		} else if (activity.equalsIgnoreCase("Concert")) {
			List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23","concert", 20, 1);
			model.addAttribute("results", result);
			return new ModelAndView("eventfulResults");
		} else if (activity.equalsIgnoreCase("Sports Game")) {
			List <Event> result = Eventful.search("Detroit", APISetDate.TODAY2 +"00-" + APISetDate.TODAY + "23","sport", 20, 1);
			model.addAttribute("results", result);
			return new ModelAndView("eventfulResults");
		} 
		else { 
			String projectUrl = "https://www.google.com/#q=" + activity ;
            return new ModelAndView("redirect:" + projectUrl);
		}
	}

		

	
		
		
	
}
