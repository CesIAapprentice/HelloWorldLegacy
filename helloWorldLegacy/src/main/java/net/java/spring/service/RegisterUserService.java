package net.java.spring.service;
import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface RegisterUserService {
	void insertUser(RegisterUserBean register)throws SQLException;
}