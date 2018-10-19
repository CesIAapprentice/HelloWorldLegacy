package net.java.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.dao.LoginDao;
import net.java.spring.dao.LoginDaoImplement;
import net.java.spring.model.LoginBean;
import net.java.spring.service.LoginService;
import net.java.spring.service.LoginServiceImplement;

@Controller
public class LoginController {
	
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginGET(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("login") LoginBean login) throws SQLException {
		this.loginService = new LoginServiceImplement();
		
		// if user and password matches DB
		if(loginService.validateNewUser(login) != null) {
			ModelAndView mav = new ModelAndView("success");
			mav.addObject("success", new LoginBean());
			return mav;
		}
		
		// if user and password doesn't match DB but user exists in DB
		if(loginService.validateNewUser(login) == null && loginService.isUserInDatabase(login) != null) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", "login incorrect");
			mav.addObject("loginError", "wrong username and/or password. Please try again.");
			return mav;
		}
		
		// if user not found in DB
		if(loginService.isUserInDatabase(login) == null) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new LoginBean());
			mav.addObject("userNotFound", "User not found.");
			return mav;
		}
		return null;
	}
}