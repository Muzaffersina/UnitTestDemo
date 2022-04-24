package com.example.testdemo.entities.concretes;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
	
	private int id; 
	
	private double total;
	
	private int customerId;
	
	private int transactionId;
	
	private LocalDate date; 
}





//add payment -- >> Customer , CreditCard  = = Request
//Bu müşterinin sistemde olması gerekir .. yoksa business exception 
//Exp. date bu aydan önce olması gerekir.. 
// Banka sisteminin kredi kartına onay vermesi gerekir. 

// herşey in memory

