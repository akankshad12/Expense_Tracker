package com.example.akanksha.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.akanksha.expense.model.Category;
import com.example.akanksha.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")

public class CategoryController {

	private final CategoryRepository categoryRepository;

	public CategoryController(final CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/categories")
	Collection<Category> categories() {
		return categoryRepository.findAll();
		// select * from category

	}

	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable final Long id) {
		final Optional<Category> category = categoryRepository.findById(id); // optional type of category might not
																				// return
		// anything
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping("/category")

	ResponseEntity<Category> createCategory(@Valid @RequestBody final Category category) throws URISyntaxException {
		final Category result = categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

	}

	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategory(@Valid @RequestBody final Category category) {
		final Category result = categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable final Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
