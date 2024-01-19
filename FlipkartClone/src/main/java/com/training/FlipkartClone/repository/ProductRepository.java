package com.training.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FlipkartClone.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
