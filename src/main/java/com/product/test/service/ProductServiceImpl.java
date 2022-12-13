package com.product.test.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.product.test.config.Constant;
import com.product.test.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Product> similarProducts(String productId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ArrayList<Product> products = new ArrayList<Product>();

		try {

			String[] response = restTemplate.getForObject(Constant.SIMILARS_IDS + productId + "/similarids",
					String[].class);

			if (response.length > 0) {
				for (String string : response) {

					Product product = new Product();

					HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
					
					try { 						

					ResponseEntity<Product> result = restTemplate.exchange(Constant.PRODUCT_DETAILS + string.toString(),
							HttpMethod.GET, entity, new ParameterizedTypeReference<Product>() {
							});

					products.add(new Product(result.getBody().getId(), result.getBody().getName(),
							result.getBody().getPrice(), result.getBody().isAvailability()));
					
					} catch (HttpServerErrorException e ) {  
						log.debug(e.toString());
						return products;
					}
				}

			}

		} catch (HttpClientErrorException e) {
			log.debug(e.toString());
			return products;
		}

		return products;
	}

}
