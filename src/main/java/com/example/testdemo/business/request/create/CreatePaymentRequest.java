package com.example.testdemo.business.request.create;

import com.example.testdemo.entities.concretes.CreditCard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreatePaymentRequest {
	
	private int id; 
	
	private double total;
	
	private int customerId;
	
	private int transactionId;
	
	private CreateCreditCardRequest creditCardRequest; 
}