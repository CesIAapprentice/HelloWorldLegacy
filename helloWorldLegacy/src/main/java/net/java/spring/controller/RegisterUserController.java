package net.java.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.model.RegisterUserBean;
import net.java.spring.service.RegisterUserService;
import net.java.spring.service.RegisterUserServiceImplement;

@Controller
public class RegisterUserController {
	
	RegisterUserService registerUserService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGET(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register", new RegisterUserBean());
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("register") RegisterUserBean register) throws SQLException {
		this.registerUserService = new RegisterUserServiceImplement();
		registerUserService.insertUser(register);
		ModelAndView mav = new ModelAndView("registersuccess");
		mav.addObject("registerSuccess", register.getUsername());
		return mav;
	}
}