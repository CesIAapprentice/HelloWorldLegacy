package net.java.spring.service;

import java.sql.SQLException;

import net.java.spring.dao.LoginDao;
import net.java.spring.dao.LoginDaoImplement;
import net.java.spring.model.LoginBean;

public class LoginServiceImplement implements LoginService{
	
	LoginDao loginDao;
	
	@Override
	public LoginBean validateNewUser(LoginBean loginBean) throws SQLException {
		this.loginDao = new LoginDaoImplement();
		return loginDao.validateNewUser(loginBean);
	}

	@Override
	public LoginBean isUserInDatabase(LoginBean loginBean) throws SQLException {
		this.loginDao = new LoginDaoImplement();
		return loginDao.isUserInDatabase(loginBean);
	}
}