package com.cs.hackathon.heybuddy.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveProductService {
     
	@Autowired
	ProductsDAO productsDAO;
	protected Long removeProduct(Long id) throws Exception {
		return productsDAO.removeProduct(id);
	}
}
