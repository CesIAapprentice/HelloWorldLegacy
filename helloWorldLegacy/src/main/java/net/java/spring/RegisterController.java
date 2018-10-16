package net.java.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("registerBean") RegisterBean registerBean) {
		  
		  System.out.println(registerBean.getName());
		  System.out.println(registerBean.getAge());
		  System.out.println(registerBean.getEmail());

	    if (registerBean != null && registerBean.getName() != null & registerBean.getAge() != null & registerBean.getEmail() != null) {
	    	//if ((registerBean.getUserName().equals("admin")) && (registerBean.getPassword().equals("admin"))) {
	    	  //model.addAttribute("ok", "Nice Details");
		      //return "home";
	    	
	    	
	    	
	    	model.addAttribute("msg", registerBean.getUserName());
	    	return "success";
	      } else {
	        model.addAttribute("error", "Invalid User: "+registerBean.getUserName()+ " and/or password: "+registerBean.getPassword());
	        return "home";
	      }
	    } else {
	      model.addAttribute("mistake", "Please enter Details");
	      return "home";
	    }
	  }
	

}
