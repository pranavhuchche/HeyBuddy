package com.cs.hackathon.heybuddy.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductsService {

	@Autowired
	ProductsDAO productsDAO;

	protected Product getProductById(Long id) throws Exception {
		return productsDAO.getProductFromId(id);
	}
	
	protected List<Product> getAllProducts() throws Exception {
		return productsDAO.getAllProducts();
	}

}
