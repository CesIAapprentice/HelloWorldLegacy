package net.java.spring;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.connection.UserDao;
import net.java.spring.connection.UserDaoImplement;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	UserDao userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginGET(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("login") LoginBean login) throws SQLException {
		this.userDao = new UserDaoImplement();
		if(userDao.validateNewUser(login) != null) {
			ModelAndView mav = new ModelAndView("success");
			mav.addObject("success", new LoginBean());
			return mav;
		}
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", "login incorrect");
		return mav;
	}
}