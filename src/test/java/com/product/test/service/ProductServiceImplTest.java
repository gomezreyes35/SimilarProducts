package com.product.test.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.product.test.model.Product;


@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Test
	public void test_controller_ok() {		
		
		List<Product> products = productServiceImpl.similarProducts("1");		
		Assert.assertNotNull(products);		
	}
	
	@Test
	public void test_controller_ko() {		
		
		List<Product> products = productServiceImpl.similarProducts("FAKE");		
		assertTrue(products.isEmpty());		
	}
}
