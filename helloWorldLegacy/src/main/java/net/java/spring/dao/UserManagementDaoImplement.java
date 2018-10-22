package net.java.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import net.java.spring.model.LoginBean;
import net.java.spring.model.RegisterUserBean;

public class UserManagementDaoImplement implements UserManagementDao{
	
	@Override
	public LoginBean validateNewUser(LoginBean loginBean) throws SQLException {
		// to do, validate existence of loginBean.getUserName() & loginBean.getPassword() in sql.db
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlValidate = "SELECT * FROM users WHERE username='" + loginBean.getUsername() + "' AND password='" + loginBean.getPassword() + "'";
		return jdbcTemplate.query(sqlValidate, new ResultSetExtractor<LoginBean>() {
			 
			@Override
			public LoginBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					LoginBean user = new LoginBean();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					return user;
				}
				return null;
			}
		});
	}

	@Override
	public LoginBean isUserInDatabase(String username) throws SQLException {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlUserInDatabase = "SELECT * FROM users WHERE username='" + username +"'";
		return jdbcTemplate.query(sqlUserInDatabase, new ResultSetExtractor<LoginBean>() {
			 
			@Override
			public LoginBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					LoginBean user = new LoginBean();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					return user;
				}
				return null;
			}
		});
	}
	
	@Autowired
	@Override
	public void insertUser(RegisterUserBean userBean) throws SQLException {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlInsert = "INSERT INTO users (username, password, email)" + " VALUES (?, ?, ?)";
		jdbcTemplate.update(sqlInsert, userBean.getUsername(), userBean.getPassword(), userBean.getEmail());	
	}
	

}
