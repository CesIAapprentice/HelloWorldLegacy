package net.java.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.connection.UserDatabaseManagement;

@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGET(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("register");
		mav.addObject("newUser", new RegisterBean());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("register") RegisterBean register) {
		
		UserDatabaseManagement manageDatabase = new UserDatabaseManagement();
		
		if(!manageDatabase.isUserInDatabase(register.getUsername())) {
			manageDatabase.insertUser(new User(register.getUsername(), register.getPassword(), register.getEmail()));
			ModelAndView mav = null;
			mav = new ModelAndView("registersuccess");
			mav.addObject("registerSuccess", register.getUsername());
			return mav;
		}
		ModelAndView mav = null;
		mav = new ModelAndView("registersuccess");
		mav.addObject("userAlreadyInDatabase", register.getUsername());
		return mav;
	}
}