package net.java.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.model.LoginBean;
import net.java.spring.service.UserManagementService;
import net.java.spring.service.UserManagementServiceImplement;

@Controller
public class LoginController {
	
	private UserManagementService userManagementService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginGET(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("login") LoginBean login) throws SQLException {
		this.userManagementService = new UserManagementServiceImplement();
		
		// if user and password matches DB
		if(userManagementService.validateNewUser(login) != null) {
			
			// User Storehouse get to his own home
			if(login.getUsername().equals("Storehouse")) {
				return "redirect:/enterproducts";
			} else {
				// Any other user gets to main home
				return "redirect:/displayproducts";
			}
		}
		
		// if user and password doesn't match DB but user exists in DB
		if(userManagementService.validateNewUser(login) == null && 
				userManagementService.isUserInDatabase(login.getUsername()) != null) {
			return "redirect:/login";
		}
		
		// if user not found in DB
		if(userManagementService.isUserInDatabase(login.getUsername()) == null) {
			return "redirect:/register";
		}
		return null;
	}
}