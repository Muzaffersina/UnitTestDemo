package com.example.testdemo.business.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerBalanceRequest {
	

	private int id;
	private int customerId;
	private double balance;

}
