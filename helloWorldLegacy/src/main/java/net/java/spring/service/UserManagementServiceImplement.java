package net.java.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import net.java.spring.dao.UserManagementDao;
import net.java.spring.dao.UserManagementDaoImplement;
import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public class UserManagementServiceImplement implements UserManagementService {
	
	UserManagementDao userManagementDao;
	
	@Override
	public LoginBean validateNewUser(LoginBean loginBean) throws SQLException {
		this.userManagementDao = new UserManagementDaoImplement();
		return userManagementDao.validateNewUser(loginBean);
	}

	@Override
	public LoginBean isUserInDatabase(String username) throws SQLException {
		this.userManagementDao = new UserManagementDaoImplement();
		return userManagementDao.isUserInDatabase(username);
	}
	
	UserManagementDaoImplement registerUserDaoImplement = new UserManagementDaoImplement();
	
	@Autowired
	@Override
	public void insertUser(RegisterUserBean userBean) throws SQLException {
		registerUserDaoImplement.insertUser(userBean);
	}
}
