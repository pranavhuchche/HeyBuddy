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
	
	protected IGetProductsResponseModel getAllProducts(IGetProductsRequestModel model) throws Exception {
		IGetProductsResponseModel returnModel = new GetProductsResponseModel();
		List<GetProduct> allProducts = productsDAO.getAllProducts(model);
		returnModel.setProducts(allProducts);
		returnModel.setTotalContent((long) allProducts.size());
		return returnModel;
	}
	
	protected void markProductInterested(Long id, String username) throws Exception {
		productsDAO.markProductInterested(id, username);
	}

}
