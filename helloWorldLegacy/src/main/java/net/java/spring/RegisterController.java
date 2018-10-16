package net.java.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	DDBB thisddbb = new DDBB();
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("registerBean") RegisterBean registerBean) {
		  
	    if (registerBean != null && registerBean.getName() != null & registerBean.getAge() != null & registerBean.getEmail() != null) {
	    	User temp = new User(registerBean.getName(), registerBean.getAge(), registerBean.getEmail());
	    	if(!thisddbb.getUserdatabase().contains(temp)) {
	    		thisddbb.getUserdatabase().add(temp);
	    		model.addAttribute("msg", registerBean.getName());
	    		return "registersuccess";
	    	} else {
	    		model.addAttribute("alreadyRegistered", registerBean.getName() + "already registered, please log in instead" );
		    	return "login";
	    	}

	    } else {
	    	model.addAttribute("mistake", "Please enter Details");
	      return "login";
	    }
	}
}