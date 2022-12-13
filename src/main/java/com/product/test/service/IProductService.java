package com.product.test.service;

import java.util.List;

import com.product.test.model.Product;

public interface IProductService {
	
	List<Product> similarProducts(String productId);

}
