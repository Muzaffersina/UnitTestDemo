package com.example.testdemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.testdemo.business.abstracts.CreditCardService;
import com.example.testdemo.business.abstracts.CustomerBalanceService;
import com.example.testdemo.business.abstracts.CustomerService;
import com.example.testdemo.business.concretes.CreditCardManager;
import com.example.testdemo.business.concretes.CustomerBalanceManager;
import com.example.testdemo.business.concretes.CustomerManager;
import com.example.testdemo.business.concretes.PaymentManager;
import com.example.testdemo.business.request.create.CreateCreditCardRequest;
import com.example.testdemo.business.request.create.CreatePaymentRequest;
import com.example.testdemo.common.exceptions.BusinesssException;

@ExtendWith(MockitoExtension.class)
public class PaymentManagerTests {
	
	private PaymentManager paymentManager;
	private CustomerService customerService;
	private CustomerBalanceService customerBalanceService;
	private CreditCardService creditCardService;
	
	@BeforeEach
	public void setUp() {
		
		customerService = new CustomerManager();
		customerBalanceService = new CustomerBalanceManager();
		creditCardService = new CreditCardManager();
		
		paymentManager = new PaymentManager(creditCardService, customerService, customerBalanceService);
		
	}

	@Test
	public void throws_exception_when_customer_not_exists() {
		
		CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest();
		createCreditCardRequest.setCardHolder("ali");
		createCreditCardRequest.setCardNumber("515156");
		createCreditCardRequest.setCsv("552");
		createCreditCardRequest.setExpiration("0540");
		createPaymentRequest.setId(1);
		createPaymentRequest.setCustomerId(7); //customer id 7 does not exist
		createPaymentRequest.setTotal(10);
		createPaymentRequest.setTransactionId(2);
		createPaymentRequest.setCreditCardRequest(createCreditCardRequest);
		
		Executable executable=() -> paymentManager.add(createPaymentRequest);
		
		Assertions.assertThrows(BusinesssException.class, executable);
		
	}
	
	@Test
	public void throws_exception_when_customer_balance_not_enough() {
		
		CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest();
		createCreditCardRequest.setCardHolder("ali");
		createCreditCardRequest.setCardNumber("515156");
		createCreditCardRequest.setCsv("552");
		createCreditCardRequest.setExpiration("0540");
		createPaymentRequest.setId(1);
		createPaymentRequest.setCustomerId(1); 
		createPaymentRequest.setTotal(150); // customer id 1 has a balance of 100
		createPaymentRequest.setTransactionId(2);
		createPaymentRequest.setCreditCardRequest(createCreditCardRequest);
		
		Executable executable=() -> paymentManager.add(createPaymentRequest);
		
		Assertions.assertThrows(BusinesssException.class, executable);
		
	}
	
	@Test
	public void throws_exception_when_credit_card_expired() {
		
		CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest();
		createCreditCardRequest.setCardHolder("ali");
		createCreditCardRequest.setCardNumber("515156");
		createCreditCardRequest.setCsv("552");
		createCreditCardRequest.setExpiration("0518"); // invalid credit card for date
		createPaymentRequest.setId(1);
		createPaymentRequest.setCustomerId(1); 
		createPaymentRequest.setTotal(50); 
		createPaymentRequest.setTransactionId(2);
		createPaymentRequest.setCreditCardRequest(createCreditCardRequest);
		
		Executable executable=() -> paymentManager.add(createPaymentRequest);
		
		Assertions.assertThrows(BusinesssException.class, executable);
		
	}
}
