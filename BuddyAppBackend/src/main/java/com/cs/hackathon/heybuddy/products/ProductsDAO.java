package com.cs.hackathon.heybuddy.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * This class will have all method related to listings APIs
 * 
 * @author Vannya, Jamil
 *
 */
@Component
public class ProductsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	protected Product getProductFromId(long id) throws Exception {
		String query = "SELECT * FROM heybuddy.products WHERE product_id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new ProductRowMapper());
	}

	protected List<GetProduct> getAllProducts(IGetProductsRequestModel model) throws Exception {
		String username = model.getUsername();
		String searchText = model.getSearchText();
		Integer listingType = model.getListingType();
		String sortOrder = "desc".equals(model.getSortOrder()) ? "desc" : "asc";
		
		StringBuilder query = new StringBuilder("Select *, "
				+ "(SELECT CASE WHEN (Select count(*) from heybuddy.users_products_interest upi where upi.username = '");
		query.append(username);
		query.append("' AND pr.product_id = upi.product_id ) > 0 THEN true ELSE false END) is_interested"
				+ " from heybuddy.products pr WHERE pr.status = true");
		if (searchText != null && !"".equals(searchText)) {
			query.append(" AND (pr.product_name ilike '%" + searchText + "%' OR pr.description ilike '%" + searchText + "%')");
		}
		if (listingType != null && listingType != 0) {
			query.append(" AND pr.listing_type = " + listingType);
		}
		query.append(" ORDER BY listing_date " + sortOrder + " OFFSET " + model.getFrom() + " LIMIT " + model.getSize());
		
		return jdbcTemplate.query(query.toString(), new GetProductRowMapper());
	}

	protected Product createNewProduct(Product product) throws Exception {
		StringBuilder query = new StringBuilder(
				"INSERT INTO heybuddy.products( product_name, description, mobile_number, cost_from, cost_to, status, listing_date, listing_type, username)");
		query.append(" VALUES ('");
		query.append(product.getProductName() + "','");
		query.append(product.getDescription() + "','");
		query.append(product.getMobileNumber() + "',");
		query.append(product.getCost_from() + ",");
		query.append(product.getCost_to() + ",");
		query.append(product.isStatus() + ",'");
		query.append(product.getListingDate() + "',");
		query.append(product.getListingType().ordinal() + ",'");
		query.append(product.getUsername() + "'");
		query.append(") RETURNING *");
		return jdbcTemplate.queryForObject(query.toString(), null, new ProductRowMapper());
	}

	
	/**This method will set status of product to false 
	 * if user this  call removeProduct API
	 * @param id
	 * @return
	 * @throws Exception
	 */
	protected Long removeProduct(Long id) throws Exception {
		String query = "UPDATE heybuddy.products SET status = false WHERE product_id = "+ id;
		jdbcTemplate.execute(query);
		return id;
	}
	
	protected void markProductInterested(Long id, String username) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO heybuddy.users_products_interest(username, product_id)");
		query.append(" VALUES ('");
		query.append(username + "',");
		query.append(id + ")");
		jdbcTemplate.execute(query.toString());
	}
}
