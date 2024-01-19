package com.training.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FlipkartClone.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>  {
}
