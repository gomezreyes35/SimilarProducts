package com.product.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.product.test.model.Product;

import com.product.test.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping(value = "/product/{productId}/similar")
	public ResponseEntity<Product> getSimilarProducts(@PathVariable String productId){

		List<Product> products = productService.similarProducts(productId);

		if (products.isEmpty()) {
			return new ResponseEntity("Product Not found",HttpStatus.NOT_FOUND);
			
		}
		 return new ResponseEntity(products, HttpStatus.OK);
	}

}
