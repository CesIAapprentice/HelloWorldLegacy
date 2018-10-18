package net.java.spring.connection;
import java.sql.SQLException;

import net.java.spring.LoginBean;
import net.java.spring.UserBean;

public interface UserDao {
	
	   void insertUser(UserBean register)throws SQLException;
	   UserBean validateNewUser(LoginBean loginBean) throws SQLException;

		
}
