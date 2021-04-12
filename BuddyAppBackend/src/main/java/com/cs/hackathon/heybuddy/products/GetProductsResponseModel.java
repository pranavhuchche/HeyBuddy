package com.cs.hackathon.heybuddy.products;

import java.util.ArrayList;
import java.util.List;

public class GetProductsResponseModel implements IGetProductsResponseModel {

	protected List<GetProduct> products = new ArrayList<>();
	protected Long totalContent = 0l;

	@Override
	public List<GetProduct> getProducts() {
		return products;
	}

	@Override
	public void setProducts(List<GetProduct> products) {
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
