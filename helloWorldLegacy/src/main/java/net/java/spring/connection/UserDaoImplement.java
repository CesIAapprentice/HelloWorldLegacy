package net.java.spring.connection;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


import net.java.spring.UserBean;
import net.java.spring.LoginBean;

public class UserDaoImplement implements UserDao{

	@Autowired
	@Override
	public void insertUser(UserBean userBean) throws SQLException {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlInsert = "INSERT INTO users (username, password, email)" + " VALUES (?, ?, ?)";
		jdbcTemplate.update(sqlInsert, userBean.getUsername(), userBean.getPassword(), userBean.getEmail());	
	}


	@Override
	public UserBean validateNewUser(LoginBean loginBean) throws SQLException {
		// to do, validate existence of loginBean.getUserName() & loginBean.getPassword() in sql.db
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlValidate = "SELECT * FROM users WHERE username='" + loginBean.getUserName() + "' AND password='" + loginBean.getPassword() + "'";
		return jdbcTemplate.query(sqlValidate, new ResultSetExtractor<UserBean>() {
			 
			@Override
			public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserBean user = new UserBean();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setEmail(rs.getString(3));
					return user;
				}
				return null;
			}
		});
		//return null;
	}
}
