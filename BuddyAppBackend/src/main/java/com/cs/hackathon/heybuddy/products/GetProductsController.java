package com.cs.hackathon.heybuddy.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductsController {

	@Autowired
	GetProductsService getProductsService;

	@GetMapping("/getproducts/{id}")
	public Product getProductById(@PathVariable Long id) throws Exception {
		return getProductsService.getProductById(id);
	}
	
	@PostMapping("/getproducts/all")
	public IGetProductsResponseModel getAllProducts(@RequestBody GetProductsRequestModel model,
			@RequestHeader(value = "user") String username) throws Exception {
		model.setUsername(username);
		return getProductsService.getAllProducts(model);
	}
	
	@GetMapping("/mark/insterested/{id}")
	public void markProductInterested(@PathVariable Long id,
			@RequestHeader(value = "user") String username) throws Exception {
		getProductsService.markProductInterested(id, username);
	}
}
