package com.cs.hackathon.heybuddy.products;

import java.time.LocalDate;
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

	protected Product createNewProduct(Product product) throws Exception {
		StringBuffer query = new StringBuffer(
				"INSERT INTO heybuddy.products( product_name, description, mobile_number, cost_from, cost_to, status, listing_date, listing_type, username)"
						+ "	VALUES ('" 
						+ product.getProductName() + "','" 
						+ product.getDescription() + "','"
						+ product.getMobileNumber() + "'," 
						+ product.getCost_from() + "," 
						+ product.getCost_to() + ","
						+ product.isStatus() + ",'" 
						+ LocalDate.now() + "'," 
						+ product.getListingType().ordinal() + ",'" 
						+ product.getUsername() + "'" 
						+ ") RETURNING *");
		return jdbcTemplate.queryForObject(query.toString(), null, new ProductRowMapper());

	}
}
