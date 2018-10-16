package net.java.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
       /**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("msg", "Please Enter Your Login Details");
		
		return "home";
	}
	
@RequestMapping(value = "/home", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "home";
	  }

@RequestMapping(method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		  
		  System.out.println(loginBean.getUserName());
		  System.out.println(loginBean.getPassword());

	    if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
	      if ((loginBean.getUserName().equals("admin")) && (loginBean.getPassword().equals("admin"))) {
	    	  //model.addAttribute("ok", "Nice Details");
		      //return "home";
	    	  
	    	  model.addAttribute("msg", loginBean.getUserName());
	    	  return "success";
	      } else {
	        model.addAttribute("error", "Invalid User: "+loginBean.getUserName()+ " and/or password: "+loginBean.getPassword());
	        return "home";
	      }
	    } else {
	      model.addAttribute("mistake", "Please enter Details");
	      return "home";
	    }
	  }
}