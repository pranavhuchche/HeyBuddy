package com.cs.hackathon.heybuddy.products;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getLong(1));
		product.setProductName(rs.getString(2));
		product.setDescription(rs.getString(3));
		product.setMobileNumber(rs.getString(4));
		product.setCost_from(rs.getLong(5));
		product.setCost_to(rs.getLong(6));
		product.setStatus(rs.getBoolean(7));
		product.setUsername(rs.getString(8));
		return product;
	}

}
