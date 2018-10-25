package net.java.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import net.java.spring.model.EnterNewProductBean;
import net.java.spring.model.LoginBean;
import net.java.spring.model.ProductModel;

public class ProductManagementDaoImplement implements ProductManagementDao{

	@Override
	public void insertProduct(EnterNewProductBean productBean) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sqlInsert = "INSERT INTO products (id, name, price)" + " VALUES (?, ?, ?)";
		jdbcTemplate.update(sqlInsert, productBean.getId(), productBean.getName(), productBean.getPrice());	
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
	public List<ProductModel> getAllProducts() throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlGetAllProducts = "SELECT * FROM products";
		return jdbcTemplate.query(sqlGetAllProducts, new ResultSetExtractor<List<ProductModel>>() {
			 
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProductModel> productList = new ArrayList<ProductModel>();
				while (rs.next()) {
					productList.add(new ProductModel(rs.getString(1), rs.getString(2), rs.getInt(3)));
				}
			
			return productList;
			}	
		});
	}

	@Override
	public ProductModel getProduct(String id) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlGetProduct = "SELECT * FROM products WHERE id='" + id + "'";
		return jdbcTemplate.query(sqlGetProduct, new ResultSetExtractor<ProductModel>() {
			 
			@Override
			public ProductModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					return new ProductModel(rs.getString(1), rs.getString(2), rs.getInt(3));
				}
				return null;
			}	
		});
	}
}