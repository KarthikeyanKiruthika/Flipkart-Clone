package com.training.FlipkartClone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.FlipkartClone.model.CustomerOrder;
import com.training.FlipkartClone.repository.CustomerOrderRepository;


@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {
		@Autowired
		private CustomerOrderRepository custorRepo;
		
		@GetMapping("/{id}")
		public Optional<CustomerOrder> getCustomerorder(@PathVariable int id){
			Optional<CustomerOrder> customerorder = custorRepo.findById(id);
			if(customerorder.isPresent())
				return customerorder;
			else {
				return Optional.empty();
			}
		}
		@GetMapping
		public List<CustomerOrder> getCustomers(){
			return  custorRepo.findAll();
		}
		@PostMapping
		public String createCustomerOrder(@RequestBody CustomerOrder customerorder) {
			custorRepo.save(customerorder);
			return "Sign-up completed";
		}
		
		@PutMapping("/{id}")
		public HttpStatus updateCustomerOrder(@PathVariable int id, @RequestBody CustomerOrder customerorder) {
			Optional<CustomerOrder>c = custorRepo.findById(id);
			if(c.isEmpty()) {
				return HttpStatus.NO_CONTENT;
			}
			else {
				CustomerOrder exist = c.get();
				exist.setOrderDate(customerorder.getOrderDate());
				custorRepo.save(exist);
				return HttpStatus.OK;
			}
					
		
		}
		
		@DeleteMapping("/{id}")
		public String deleteCustomerOrder(@PathVariable int id) {
			custorRepo.deleteById(id);
			return "Account Deleted";
		}
}
