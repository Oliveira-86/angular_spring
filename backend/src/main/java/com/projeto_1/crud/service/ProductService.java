package com.projeto_1.crud.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projeto_1.crud.entity.Product;
import com.projeto_1.crud.repository.ProductRepository;
import com.projeto_1.crud.service.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		List<Product> list = repository.findAll();
		return list;
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		return repository.save(newObj);
	}
	
	public void delete(Long id) {
		findById(id); 
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Product upDate(Long id, Product obj) {
		try {
			Product entity = repository.getOne(id);
			upDateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void upDateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		
	}
}
