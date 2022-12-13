package com.product.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimilarProductsApplication {
	
	@Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(SimilarProductsApplication.class, args);
	}

}
