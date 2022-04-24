package com.example.testdemo.business.request.create;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
	
	private String cardHolder; 
	
	private String cardNumber;
	
	private String csv;
	
	private String expiration;

}