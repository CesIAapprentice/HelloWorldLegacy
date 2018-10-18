package net.java.spring;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.connection.UserDaoImplement;

@Controller
public class UserController {
	
	UserDaoImplement userDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGET(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register", new UserBean());
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("register") UserBean register) throws SQLException {
		this.userDao = new UserDaoImplement();
		userDao.insertUser(register);
		ModelAndView mav = new ModelAndView("registersuccess");
		mav.addObject("registerSuccess", register.getUsername());
		return mav;
	}
}