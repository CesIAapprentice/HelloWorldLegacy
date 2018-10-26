package net.java.spring.service;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.Product;

public interface ProductManagementService {
	public void insertProduct (EnterNewProductBean productBean) throws SQLException;
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException;
	public Product getProduct(String id) throws SQLException;
	public List<Product> getAllProducts () throws SQLException;
}
