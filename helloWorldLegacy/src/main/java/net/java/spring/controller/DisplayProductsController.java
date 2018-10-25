package net.java.spring.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.java.spring.service.ProductManagementService;
import net.java.spring.service.ProductManagementServiceImplement;

@Controller
@RequestMapping(value = "displayproducts")
public class DisplayProductsController {
	
	ProductManagementService productManagementService;

		@RequestMapping(method = RequestMethod.GET)
		public String showProducts(ModelMap modelMap) throws SQLException {
		this.productManagementService = new ProductManagementServiceImplement();	
			modelMap.put("products", this.productManagementService.getAllProducts());
			
	            return "displayproducts";
		}
}