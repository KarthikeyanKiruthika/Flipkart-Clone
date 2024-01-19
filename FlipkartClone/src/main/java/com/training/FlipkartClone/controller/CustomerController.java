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

import com.training.FlipkartClone.model.Customer;
import com.training.FlipkartClone.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository custRepo;
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id){
		Optional<Customer> customer = custRepo.findById(id);
		if(customer.isPresent())
			return customer;
		else {
			return Optional.empty();
		}
	}
	@GetMapping
	public List<Customer> getCustomers(){
		return  custRepo.findAll();
	}
	@PostMapping
	public String createCustomer(@RequestBody Customer customer) {
		custRepo.save(customer);
		return "Sign-up completed";
	}
	
	@PutMapping("/{id}")
	public HttpStatus updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		Optional<Customer>c = custRepo.findById(id);
		if(c.isEmpty()) {
			return HttpStatus.NO_CONTENT;
		}
		else {
			Customer exist = c.get();
			exist.setPassword(customer.getPassword());
			custRepo.save(exist);
			return HttpStatus.OK;
		}
				
	
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) {
		custRepo.deleteById(id);
		return "Account Deleted";
	}
}
