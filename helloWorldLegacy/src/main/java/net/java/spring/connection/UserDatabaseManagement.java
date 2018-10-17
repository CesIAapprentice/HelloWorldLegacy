package net.java.spring.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.java.spring.User;

public class UserDatabaseManagement implements UserDao{

	@Override
	public User getUser(String username) {
		Connection conn = ConnectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username=" + username);
	        if(rs.next())
	        {
	            User user = new User();
	            user.setUsername( rs.getString("username") );
	            user.setPassword( rs.getString("password") );
	            user.setEmail( rs.getString("email") );
	            return user;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	   return null;
	}
	
	@Override
	public boolean insertUser(User user) {
		Connection connection = ConnectionFactory.getConnection();
		   try {
		       PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES ('1', ?, ?, ?)");
		       ps.setString(1, user.getUsername());
		       ps.setString(2, user.getPassword());
		       ps.setString(3, user.getEmail());
		       int i = ps.executeUpdate();
		     if(i == 1) {
		       return true;
		     }
		   } catch (SQLException ex) {
		       ex.printStackTrace();
		   }
		   return false;
		}


	@Override
	public boolean isUserInDatabase(String username) {
		User temp = this.getUser(username);
		if(temp == null) {
			return false;
		} else return true;
	}

	@Override
	public boolean isLoginCorrect(String username, String password) {
		if(this.isUserInDatabase(username)) {
			User temp = this.getUser(username);
			if(temp.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
