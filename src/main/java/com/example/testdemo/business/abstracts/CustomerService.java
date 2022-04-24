package com.example.testdemo.business.abstracts;

import com.example.testdemo.business.request.create.CreateCustomerRequest;

public interface CustomerService {
	void add(CreateCustomerRequest createCustomerRequest);
	boolean checkCustomerId(int customerId);
}
