package com.example.testdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerBalance {
	
	private int id;
	private int customerId;
	private double balance;

}
