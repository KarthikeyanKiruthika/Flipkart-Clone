package com.training.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FlipkartClone.model.CustomerOrder;


@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer>{

}
