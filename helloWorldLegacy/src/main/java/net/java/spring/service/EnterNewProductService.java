package net.java.spring.service;

import java.sql.SQLException;

import net.java.spring.model.EnterNewProductBean;

public interface EnterNewProductService {
	
	public void insertProduct (EnterNewProductBean productBean) throws SQLException;
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException;

}
