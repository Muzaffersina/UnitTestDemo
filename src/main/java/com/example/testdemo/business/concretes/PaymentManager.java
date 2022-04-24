package com.example.testdemo.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testdemo.business.abstracts.CreditCardService;
import com.example.testdemo.business.abstracts.CustomerBalanceService;
import com.example.testdemo.business.abstracts.CustomerService;
import com.example.testdemo.business.abstracts.PaymentService;
import com.example.testdemo.business.request.create.CreatePaymentRequest;
import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.Payment;
@Service
public class PaymentManager implements PaymentService{
	
	public List<Payment> payments = new ArrayList<Payment>();
	
	public CreditCardService creditCardService;
	public CustomerService customerService;
	public CustomerBalanceService customerBalanceService;
	
	@Autowired
	public PaymentManager(CreditCardService creditCardService, CustomerService customerService,
			CustomerBalanceService customerBalanceService) {	
		this.creditCardService = creditCardService;
		this.customerService = customerService;
		this.customerBalanceService = customerBalanceService;
	}
	
	@Override
	public void add(CreatePaymentRequest createPaymentRequest) {
		
		checkCustomerId(createPaymentRequest.getCustomerId());
		checkExpireDate(createPaymentRequest.getCreditCardRequest().getExpiration());
		checkIfBalanceEnough(createPaymentRequest.getCustomerId(), createPaymentRequest.getTotal());
		payments.add(toSet(createPaymentRequest));		
	}
	private  Payment toSet(CreatePaymentRequest createPaymentRequest) {
		
		Payment payment = new Payment();
		payment.setId(createPaymentRequest.getId());
		payment.setCustomerId(createPaymentRequest.getCustomerId());
		payment.setDate(LocalDate.now());
		payment.setTotal(createPaymentRequest.getTotal());
		payment.setTransactionId(createPaymentRequest.getTransactionId());
		return payment;
		
	}
	public boolean checkExpireDate(String expireDate) {
		
		String expireYear = expireDate.substring(2);
		int intExpireYear = Integer.parseInt(expireYear)+2000;
		String expireMonth = expireDate.substring(0,1);
		int intExpireMonth = Integer.parseInt(expireMonth);
		int dateNowMonth = LocalDate.now().getMonth().getValue();		
		int dateNowYear = LocalDate.now().getYear();	
		
		if(intExpireYear > dateNowYear ) {
			return true;
		}
		else if(intExpireYear == dateNowYear ) {			
			if( intExpireMonth > (dateNowMonth-1)) {
				return true;
			}
		}
		throw new BusinesssException("gecersiz son kullanma tarihi");
	}
	private void checkCustomerId(int customerId) {
		this.customerService.checkCustomerId(customerId);
	}
	private void checkIfBalanceEnough(int customerId,double total) {
		this.customerBalanceService.checkIfBalanceEnough(customerId, total);
	}
	
	
	
}
