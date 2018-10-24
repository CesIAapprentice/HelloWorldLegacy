package net.java.spring.dao;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.ProductModel;

public interface ProductManagementDao {
	
	public void insertProduct (EnterNewProductBean productBean) throws SQLException;
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException;
	public List<ProductModel> getAllProducts () throws SQLException;

}
