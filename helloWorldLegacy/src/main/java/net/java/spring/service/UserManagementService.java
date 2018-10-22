package net.java.spring.service;

import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface UserManagementService {
	
	   LoginBean validateNewUser(LoginBean loginBean) throws SQLException;
	   LoginBean isUserInDatabase(String username) throws SQLException;
	   void insertUser(RegisterUserBean register)throws SQLException;

}
