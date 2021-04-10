package com.cs.hackathon.heybuddy.products;

import java.util.ArrayList;
import java.util.List;

public class GetProductsResponseModel implements IGetProductsResponseModel {

	protected List<Product> products = new ArrayList<>();
	protected Long totalContent = 0l;

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public Long getTotalContent() {
		return totalContent;
	}

	@Override
	public void setTotalContent(Long totalContent) {
		this.totalContent = totalContent;
	}
}
