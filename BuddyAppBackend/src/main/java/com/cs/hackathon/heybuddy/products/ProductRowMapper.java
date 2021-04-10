package com.cs.hackathon.heybuddy.products;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cs.hackathon.heybuddy.products.Product.ListingType;

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
		product.setListingDate(rs.getLong(8));
		product.setListingType(ListingType.valueOf(rs.getInt(9)));
		product.setUsername(rs.getString(10));
		return product;
	}

}
