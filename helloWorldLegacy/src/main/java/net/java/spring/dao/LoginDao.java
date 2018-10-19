package net.java.spring.dao;

import java.sql.SQLException;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public interface LoginDao {
	LoginBean validateNewUser(LoginBean loginBean) throws SQLException;
	LoginBean isUserInDatabase(LoginBean loginBean) throws SQLException;
}