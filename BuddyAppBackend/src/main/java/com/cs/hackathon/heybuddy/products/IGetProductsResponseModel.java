package com.cs.hackathon.heybuddy.products;

import java.util.List;

public interface IGetProductsResponseModel {
	
	public static final String PRODUCTS = "products";
	public static final String TOTAL_CONTENT = "totalContent";
	
	public List<GetProduct> getProducts();
	public void setProducts(List<GetProduct> products);

	public Long getTotalContent();
	public void setTotalContent(Long totalContent);
}
