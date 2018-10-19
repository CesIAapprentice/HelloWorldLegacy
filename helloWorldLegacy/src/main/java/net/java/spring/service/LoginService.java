package net.java.spring.service;

import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface LoginService {
	   LoginBean validateNewUser(LoginBean loginBean) throws SQLException;
	   LoginBean isUserInDatabase(LoginBean loginBean) throws SQLException;
}