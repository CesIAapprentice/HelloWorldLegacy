package net.java.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	User thisuser = new User();
	DDBB thisddbb = new DDBB();
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("registerBean") RegisterBean registerBean) {
		  
		  String userName = registerBean.getName();
		  Integer userAge = registerBean.getAge();
		  String userEmail = registerBean.getEmail();

	    if (registerBean != null && registerBean.getName() != null & registerBean.getAge() != null & registerBean.getEmail() != null) {
	    	
	    	thisuser.setName(userName);
	    	thisuser.setAge(userAge);
	    	thisuser.setEmail(userEmail);
	    	
	    	thisddbb.getUserdatabase().add(thisuser);
	    	
	    	model.addAttribute("msg", registerBean.getName());
	    	return "registersuccess";

	    } else {
	      model.addAttribute("mistake", "Please enter Details");
	      return "home";
	    }
	  }
	

}
