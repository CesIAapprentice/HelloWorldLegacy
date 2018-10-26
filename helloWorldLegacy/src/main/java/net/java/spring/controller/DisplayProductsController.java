package net.java.spring.controller;

import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.java.spring.helpers.ZXingHelper;
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
		
		@RequestMapping(value = "barcode/{id}", method = RequestMethod.GET)
		public void barcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
			response.setContentType("image/png");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(ZXingHelper.getBarCodeImage(id, 200, 200));
			outputStream.flush();
			outputStream.close();
		}

}