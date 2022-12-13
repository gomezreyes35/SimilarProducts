package com.product.test.controller;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.product.test.model.Product;

@SpringBootTest
public class ProductControllerTest {
	
	@Autowired
	ProductController productController;
	
	@Test
	public void test_controller_ok() {
		
		ResponseEntity<Product> products = productController.getSimilarProducts("1");			
		Assert.assertNotNull(products);
		Assert.assertEquals("200 OK", products.getStatusCode().toString());		
	}
	
	@Test
	public void test_controller_ko() {
		
		ResponseEntity<Product> products = productController.getSimilarProducts("99999");			
		Assert.assertNotNull(products);
		Assert.assertEquals("404 NOT_FOUND", products.getStatusCode().toString());		
	}
	
}
