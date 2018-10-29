package net.java.spring.service;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.dao.ProductManagementDao;
import net.java.spring.dao.ProductManagementDaoImplement;
import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.Product;

public class ProductManagementServiceImplement implements ProductManagementService {
	
	ProductManagementDao productManagementDao;
	
	public void insertProduct (Product product) throws SQLException{
		this.productManagementDao = new ProductManagementDaoImplement();
		this.productManagementDao.insertProduct(product);
	}
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException{
		this.productManagementDao = new ProductManagementDaoImplement();
		return this.productManagementDao.isIDinProductDatabase(id);
	}
	public Product getProduct(String id) throws SQLException{
		this.productManagementDao = new ProductManagementDaoImplement();
		return this.productManagementDao.getProduct(id);
	}
	public List<Product> getAllProducts () throws SQLException{
		this.productManagementDao = new ProductManagementDaoImplement();
		return this.productManagementDao.getAllProducts();
	}

}
