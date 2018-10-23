package net.java.spring.dao;

import java.sql.SQLException;

import net.java.spring.model.EnterNewProductBean;

public interface ProductManagementDao {
	
	public void insertProduct (EnterNewProductBean productBean) throws SQLException;
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException;

}
