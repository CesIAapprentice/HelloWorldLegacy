package net.java.spring.dao;

import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface UserManagementDao {
	
	LoginBean validateNewUser(LoginBean loginBean) throws SQLException;
	void insertUser(RegisterUserBean register)throws SQLException;
	LoginBean isUserInDatabase(String username) throws SQLException;
	
}
