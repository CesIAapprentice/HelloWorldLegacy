package net.java.spring.dao;
import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface RegisterUserDao {
	
	   void insertUser(RegisterUserBean register)throws SQLException;
}