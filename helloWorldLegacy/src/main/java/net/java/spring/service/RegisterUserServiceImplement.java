package net.java.spring.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import net.java.spring.dao.RegisterUserDaoImplement;
import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public class RegisterUserServiceImplement implements RegisterUserService{

	RegisterUserDaoImplement registerUserDaoImplement = new RegisterUserDaoImplement();
	
	@Autowired
	@Override
	public void insertUser(RegisterUserBean userBean) throws SQLException {
		registerUserDaoImplement.insertUser(userBean);
	}
}