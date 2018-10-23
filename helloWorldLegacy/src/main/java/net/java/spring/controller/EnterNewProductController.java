package net.java.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.service.EnterNewProductService;
import net.java.spring.service.EnterNewProductServiceImplement;

@Controller
public class EnterNewProductController {
	
private EnterNewProductService enterNewProductService;
	
	@RequestMapping(value = "/enterproducts", method = RequestMethod.GET)
	public ModelAndView enterNewProductGET(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("enterproducts");
		System.out.println("Hola");
		mav.addObject("enterproducts", new EnterNewProductBean());
		return mav;
	}
	
	@RequestMapping(value = "/enterproducts", method = RequestMethod.POST)
	public ModelAndView enterNewProductPOST(HttpServletRequest request, HttpServletResponse response,
										@ModelAttribute("enterproducts") EnterNewProductBean enterproduct) throws SQLException {
		
		this.enterNewProductService = new EnterNewProductServiceImplement();
		
		if(enterNewProductService.isIDinProductDatabase(enterproduct.getId()) == null) {
			enterNewProductService.insertProduct(enterproduct);
			ModelAndView mav = new ModelAndView("enterproducts");
			mav.addObject("IDSuccessfullyAdded","ID successfully added.");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("enterproducts");
			mav.addObject("IDAlreadyInDatabase","ID already in database.");
			return mav;
		}
	}
}
