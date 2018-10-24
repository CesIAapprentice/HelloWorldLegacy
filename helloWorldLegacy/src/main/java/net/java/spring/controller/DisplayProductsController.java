package net.java.spring.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.java.spring.service.DisplayProductsService;
import net.java.spring.service.DisplayProductsServiceImplement;

@Controller
@RequestMapping(value = "displayproducts")
public class DisplayProductsController {
	
	DisplayProductsService displayProductsService;

		@RequestMapping(method = RequestMethod.GET)
		public String showProducts(ModelMap modelMap) throws SQLException {
		this.displayProductsService = new DisplayProductsServiceImplement();	
			
	        //ProductModel productModel = new ProductModel();
			//modelMap.put("products", productModel.findAll());
			modelMap.put("products", displayProductsService.getAllProducts());
			
	            return "displayproducts";
		}
}