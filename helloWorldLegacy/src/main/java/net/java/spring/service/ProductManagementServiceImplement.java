package net.java.spring.service;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.ProductModel;

public class ProductManagementServiceImplement implements ProductManagementService {
	
	ProductManagementService productManagementService;
	
	public void insertProduct (EnterNewProductBean productBean) throws SQLException{
		this.productManagementService = new ProductManagementServiceImplement();
		this.productManagementService.insertProduct(productBean);
	}
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException{
		this.productManagementService = new ProductManagementServiceImplement();
		return this.productManagementService.isIDinProductDatabase(id);
	}
	public ProductModel getProduct(String id) throws SQLException{
		this.productManagementService = new ProductManagementServiceImplement();
		return this.productManagementService.getProduct(id);
	}
	public List<ProductModel> getAllProducts () throws SQLException{
		this.productManagementService = new ProductManagementServiceImplement();
		return this.productManagementService.getAllProducts();
	}

}
