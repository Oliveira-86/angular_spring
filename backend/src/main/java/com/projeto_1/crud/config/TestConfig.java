package com.projeto_1.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto_1.crud.entity.Product;
import com.projeto_1.crud.repository.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "Cadeira", 120.00);
		Product p2 = new Product(null, "Tablet", 1800.00);
		
		repository.saveAll(Arrays.asList(p1,p2));
	}
	
	
	
	
			

}
