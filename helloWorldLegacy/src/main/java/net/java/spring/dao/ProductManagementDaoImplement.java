package net.java.spring.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.multipart.MultipartFile;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.LoginBean;
import net.java.spring.model.Product;

public class ProductManagementDaoImplement implements ProductManagementDao{

	@Override
	public void insertProduct(Product product) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlInsert = "INSERT INTO products (id, name, price, images)" + " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsert, product.getId(), product.getName(), product.getPrice(), product.getImagesnames());	
	}

	@Override
	public EnterNewProductBean isIDinProductDatabase(String id) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlUserInDatabase = "SELECT * FROM products WHERE id='" + id +"'";
		return jdbcTemplate.query(sqlUserInDatabase, new ResultSetExtractor<EnterNewProductBean>() {
			 
			@Override
			public EnterNewProductBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					EnterNewProductBean product = new EnterNewProductBean();
					product.setId(rs.getString(1));
					product.setName(rs.getString(2));
					product.setPrice(rs.getInt(3));
					return product;
				}
				return null;
			}
		});
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlGetAllProducts = "SELECT * FROM products";
		return jdbcTemplate.query(sqlGetAllProducts, new ResultSetExtractor<List<Product>>() {
			 
			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> productList = new ArrayList<Product>();
				while (rs.next()) {
					Product temp = new Product();
					temp.setId(rs.getString(1));
					temp.setName(rs.getString(2));
					temp.setPrice(rs.getInt(3));
					//temp.setImagesnames("/images/" + rs.getString(4));
					temp.setImagesnames( rs.getString(4));
					
					productList.add(temp);
					
				}
			
			return productList;
			}	
		});
	}

	@Override
	public Product getProduct(String id) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlGetProduct = "SELECT * FROM products WHERE id='" + id + "'";
		return jdbcTemplate.query(sqlGetProduct, new ResultSetExtractor<Product>() {
			 
			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Product temp = new Product();
					temp.setId(rs.getString(1));
					temp.setName(rs.getString(2));
					temp.setPrice(rs.getInt(3));
					return temp;
				}
				return null;
			}	
		});
	}
}