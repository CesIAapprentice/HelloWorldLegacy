package net.java.spring.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import net.java.spring.model.Product;
import net.java.spring.service.ProductManagementService;

@Controller
@SessionAttributes("product")
public class EnterNewProductController {
	
	private ProductManagementService productManagementService;
	
	@RequestMapping(value="enterproducts", method = RequestMethod.GET)
    public String setupForm(Model model)
    {
         Product product = new Product();
         model.addAttribute("product", product);
         return "enterproducts";
    }
	
	@RequestMapping(value="enterproducts", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("product") Product product, BindingResult result, SessionStatus status) throws SQLException
    {
        //Validation code start
        boolean error = false;
         
        System.out.println(product); //Verifying if information is same as input by user
         
        if(product.getId().isEmpty()){
            result.rejectValue("id", "error.emptyID");
            error = true;
        }
        
        if(productManagementService.isIDinProductDatabase(product.getId()) == null) {
            result.rejectValue("id", "error.iDalreadyAdded");
            error = true;
        }
         
        if(product.getName().isEmpty()){
            result.rejectValue("name", "error.name");
            error = true;
        }
         
        if(product.getPrice().toString().isEmpty()){
            result.rejectValue("price", "error.price");
            error = true;
        }
         
        if(error) {
            return "enterproducts";
        }
        status.setComplete();
        productManagementService.insertProduct(product);
        return "redirect:enterproducts";
        // mensaje de OK
        
    }

}
