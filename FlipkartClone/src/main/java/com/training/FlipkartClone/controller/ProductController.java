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

import com.training.FlipkartClone.model.Product;
import com.training.FlipkartClone.repository.ProductRepository;



@RestController
@RequestMapping("/product")
public class ProductController {
		@Autowired
			private ProductRepository proRepo;
			
			@GetMapping("/{id}")
			public Optional<Product> getProduct(@PathVariable int id){
				Optional<Product> product = proRepo.findById(id);
				if(product.isPresent())
					return product;
				else {
					return Optional.empty();
				}
			}
			@GetMapping
			public List<Product> getProduct(){
				return  proRepo.findAll();
			}
			@PostMapping
			public String createProduct(@RequestBody Product product) {
				proRepo.save(product);
				return "Sign-up completed";
			}
			
			@PutMapping("/{id}")
			public HttpStatus updateProduct(@PathVariable int id, @RequestBody Product product) {
				Optional<Product>c = proRepo.findById(id);
				if(c.isEmpty()) {
					return HttpStatus.NO_CONTENT;
				}
				else {
					Product exist = c.get();
					exist.setName(product.getName());
					proRepo.save(exist);
					return HttpStatus.OK;
				}
						
			
			}
			
			@DeleteMapping("/{id}")
			public String deleteProduct(@PathVariable int id) {
				proRepo.deleteById(id);
				return "Account Deleted";
			}
		}

