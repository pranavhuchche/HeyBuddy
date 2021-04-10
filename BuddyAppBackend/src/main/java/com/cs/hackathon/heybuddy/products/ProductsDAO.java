package com.cs.hackathon.heybuddy.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductsDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	protected Product getProductFromId(long id) throws Exception {
		String query = "SELECT * FROM heybuddy.products WHERE product_id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new ProductRowMapper());
	}
	
	protected List<Product> getAllProducts() throws Exception {
		String query = "SELECT * FROM heybuddy.products";
		return jdbcTemplate.query(query, new ProductRowMapper());
	}
}
