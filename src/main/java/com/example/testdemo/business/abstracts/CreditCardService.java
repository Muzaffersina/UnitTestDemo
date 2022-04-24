package com.example.testdemo.business.abstracts;

import com.example.testdemo.business.request.create.CreateCreditCardRequest;

public interface CreditCardService {

	void add(CreateCreditCardRequest createCreditCardRequest);

	boolean checkExpireDate(String expireDate);

}
