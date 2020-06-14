package com.example.akanksha.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.akanksha.expense.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	Category findByName(String name); //search the table in database
	
	
}
