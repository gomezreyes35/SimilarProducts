package com.product.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
	

	private String id;
	
	private String name;
	
	private double price;
	
	private boolean availability; 

}
