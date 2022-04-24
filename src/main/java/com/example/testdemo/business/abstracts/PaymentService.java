package com.example.testdemo.business.abstracts;

import com.example.testdemo.business.request.create.CreatePaymentRequest;

public interface PaymentService {
	void add(CreatePaymentRequest createPaymentRequest);
}
