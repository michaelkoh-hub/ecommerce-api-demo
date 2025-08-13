package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;

// My repository will get all the function from JpaRepository
// The first argument inside <> will be your Entity name
// The second argument inside <> will be the ID data type
// The theory term is Generic ( can refer to book as well)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// It knows I want to open up SELECT * FROM products WHERE name LIKE ''
//	List<Product> findByName (String name);
//	
//	// It will be mapped to SELECT ^ FROM products WHERE price <= 100
//	List<Product> findByPriceLessThanEqual(double price);
}

