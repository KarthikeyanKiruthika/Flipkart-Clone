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

import com.training.FlipkartClone.model.Category;
import com.training.FlipkartClone.repository.CategoryRepository;


@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
		private CategoryRepository catRepo;
		
		@GetMapping("/{id}")
		public Optional<Category> getCategory(@PathVariable int id){
			Optional<Category> category = catRepo.findById(id);
			if(category.isPresent())
				return category;
			else {
				return Optional.empty();
			}
		}
		@GetMapping
		public List<Category> getCategory(){
			return  catRepo.findAll();
		}
		@PostMapping
		public String createCategory(@RequestBody Category category) {
			catRepo.save(category);
			return "Sign-up completed";
		}
		
		@PutMapping("/{id}")
		public HttpStatus updateCategory(@PathVariable int id, @RequestBody Category category) {
			Optional<Category>c = catRepo.findById(id);
			if(c.isEmpty()) {
				return HttpStatus.NO_CONTENT;
			}
			else {
				Category exist = c.get();
				exist.setName(category.getName());
				catRepo.save(exist);
				return HttpStatus.OK;
			}
					
		
		}
		
		@DeleteMapping("/{id}")
		public String deleteCategory(@PathVariable int id) {
			catRepo.deleteById(id);
			return "Account Deleted";
		}
	}


