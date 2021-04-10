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

	protected List<Product> getAllProducts(IGetProductsRequestModel model) throws Exception {
		String searchText = model.getSearchText();
		Integer listingType = model.getListingType();
		String sortOrder = "desc".equals(model.getSortOrder()) ? "desc" : "asc";
		StringBuilder query = new StringBuilder("Select * from heybuddy.products pr WHERE 1=1");
		if (searchText != null && !"".equals(searchText)) {
			query.append(" AND (pr.product_name ilike '%" + searchText + "%' OR pr.description ilike '%" + searchText + "%')");
		}
		if (listingType != null && listingType != 0) {
			query.append(" AND pr.listing_type = " + listingType);
		}
		query.append(" ORDER BY listing_date " + sortOrder + " OFFSET " + model.getFrom() + " LIMIT " + model.getSize());
		return jdbcTemplate.query(query.toString(), new ProductRowMapper());
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
						+ product.getListingDate() + "'," 
						+ product.getListingType().ordinal() + ",'" 
						+ product.getUsername() + "'" 
						+ ") RETURNING *");
		return jdbcTemplate.queryForObject(query.toString(), null, new ProductRowMapper());

	}
}
