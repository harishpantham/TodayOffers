package com.today.offers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.today.offers.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
