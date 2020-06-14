package com.example.akanksha.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Data

public class Category {

	@Id
	private Long id;

	// Travel, Grocery- Categories we are going to connect to user

	private String name;
	// many categories can be assigned to one user

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return null;
	}

}
