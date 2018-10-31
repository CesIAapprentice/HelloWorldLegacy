package net.java.spring.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.Product;
import net.java.spring.service.ProductManagementService;
import net.java.spring.service.ProductManagementServiceImplement;

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
	public String submitForm(@ModelAttribute("product") Product product, BindingResult result, SessionStatus status, HttpServletRequest servletRequest, Model model) throws SQLException
    {
		this.productManagementService = new ProductManagementServiceImplement();

        //Validation code start
        boolean error = false;
         
        System.out.println(product.getImages()); //Verifying if information is same as input by user
         
        if(product.getId().isEmpty()){
            result.rejectValue("id", "error.emptyID");
            error = true;
        }
        
        if(productManagementService.isIDinProductDatabase(product.getId()) != null) {
            result.rejectValue("id", "error.iDalreadyAdded");
            error = true;
        }
         
        if(product.getName().isEmpty()){
            result.rejectValue("name", "error.name");
            error = true;
        }
         
        if(product.getPrice() == null){
            result.rejectValue("price", "error.price");
            error = true;
        }
         
        if(error) {
            return "enterproducts";
        }
        
      //Get the uploaded files and store them
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        
        if (null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                System.out.println("filename: " + fileName);
                fileNames.add(fileName);
                product.setImagesnames("");
                for(String thisFilename : fileNames) {
                	System.out.println("Adding " + thisFilename + " to imagesNames");
                	product.setImagesnames(product.getImagesnames().concat(thisFilename));
                }
                System.out.println("Nombres de Productos: " + product.getImagesnames());
 
                @SuppressWarnings("deprecation")
				File imageFile = new File(servletRequest.getRealPath("/images"), fileName);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
 
        // Here, you can save the product details in database
        
        
        status.setComplete();
        productManagementService.insertProduct(product);
        
        return "redirect:enterproducts";
        // mensaje de OK
        
    }

}
