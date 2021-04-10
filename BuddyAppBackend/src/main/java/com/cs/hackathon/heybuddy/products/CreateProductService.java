package com.cs.hackathon.heybuddy.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
	
	@Autowired
	ProductsDAO productsDAO;

	protected Product createNewProduct(Product product) throws Exception {
		product.setListingDate(System.currentTimeMillis());
		return productsDAO.createNewProduct(product);
	}
}
