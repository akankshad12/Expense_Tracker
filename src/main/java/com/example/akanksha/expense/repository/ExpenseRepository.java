package com.example.akanksha.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.akanksha.expense.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
