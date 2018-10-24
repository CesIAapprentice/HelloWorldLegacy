package net.java.spring.service;

import java.sql.SQLException;
import java.util.List;

import net.java.spring.dao.ProductManagementDao;
import net.java.spring.dao.ProductManagementDaoImplement;
import net.java.spring.model.ProductModel;

public class DisplayProductsServiceImplement implements DisplayProductsService {

	public List<ProductModel> getAllProducts() throws SQLException{
		ProductManagementDao productManagementDao = new ProductManagementDaoImplement();
			return productManagementDao.getAllProducts();
	}
}
