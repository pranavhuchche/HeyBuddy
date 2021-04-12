package com.cs.hackathon.heybuddy.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductController {
	@Autowired
	protected CreateProductService createProductService;

	@PostMapping("/createproduct")
	public Product createNewProduct(@RequestBody Product product) throws Exception {
		return createProductService.createNewProduct(product);
	}
}
