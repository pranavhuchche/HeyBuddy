package com.cs.hackathon.heybuddy.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveProductController {
	@Autowired
	protected RemoveProductService removeProductService;

	@DeleteMapping("/removeproduct/{id}")
	public Long getProductById(@PathVariable Long  id) throws Exception {
		return removeProductService.removeProduct(id);
	}
}
