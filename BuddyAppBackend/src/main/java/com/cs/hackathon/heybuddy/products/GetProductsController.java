package com.cs.hackathon.heybuddy.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductsController {

	@Autowired
	GetProductsService getProductsService;

	@GetMapping("/getproducts/{id}")
	public Product getProductById(@PathVariable Long id) throws Exception {
		return getProductsService.getProductById(id);
	}
	
	@GetMapping("/getproducts/all")
	public List<Product> getAllProducts() throws Exception {
		return getProductsService.getAllProducts();
	}
}
