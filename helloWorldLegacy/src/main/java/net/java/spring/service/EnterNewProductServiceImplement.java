package net.java.spring.service;

import java.sql.SQLException;

import net.java.spring.dao.ProductManagementDao;
import net.java.spring.dao.ProductManagementDaoImplement;
import net.java.spring.model.EnterNewProductBean;

public class EnterNewProductServiceImplement implements EnterNewProductService{

	@Override
	public void insertProduct(EnterNewProductBean productBean) throws SQLException {
		ProductManagementDao productManagementDao = new ProductManagementDaoImplement();
			productManagementDao.insertProduct(productBean);
	}

	@Override
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException {
		ProductManagementDao productManagementDao = new ProductManagementDaoImplement();
		return productManagementDao.isIDinProductDatabase(id);
	}
	
	
}