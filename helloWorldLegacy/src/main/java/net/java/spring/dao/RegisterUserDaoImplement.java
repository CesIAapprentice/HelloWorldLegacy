package net.java.spring.dao;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import net.java.spring.model.RegisterUserBean;

public class RegisterUserDaoImplement implements RegisterUserDao{

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