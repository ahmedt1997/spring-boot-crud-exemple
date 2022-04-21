package com.javatechie.springbootcrudexemple.repository;

import com.javatechie.springbootcrudexemple.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
