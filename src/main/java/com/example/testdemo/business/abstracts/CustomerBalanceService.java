package com.example.testdemo.business.abstracts;

import com.example.testdemo.business.request.create.CreateCustomerBalanceRequest;

public interface CustomerBalanceService {

	void add(CreateCustomerBalanceRequest createCustomerBalanceRequest);
	boolean checkCustomerExists(int customerId);
	boolean checkIfBalanceEnough(int customerId,double total);
}
