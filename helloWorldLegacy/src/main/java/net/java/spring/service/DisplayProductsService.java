package net.java.spring.service;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.model.ProductModel;

public interface DisplayProductsService {
	
	public List<ProductModel> getAllProducts() throws SQLException;
}
