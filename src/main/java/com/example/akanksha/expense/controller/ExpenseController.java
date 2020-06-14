package com.example.akanksha.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import com.example.akanksha.expense.model.Expense;
import com.example.akanksha.expense.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping("/expenses")
	List<Expense> getExpenses() {
		return expenseRepository.findAll();
	}

	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable final Long id) {
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@Valid @RequestBody final Expense expense) throws URISyntaxException {
		final Expense result = expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
	}
}