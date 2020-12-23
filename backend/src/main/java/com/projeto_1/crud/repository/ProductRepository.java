package com.projeto_1.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_1.crud.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
