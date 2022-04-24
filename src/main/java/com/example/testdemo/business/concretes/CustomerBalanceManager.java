package com.example.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.testdemo.business.abstracts.CustomerBalanceService;
import com.example.testdemo.business.request.create.CreateCustomerBalanceRequest;
import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.CustomerBalance;
@Service
public class CustomerBalanceManager implements CustomerBalanceService {

	public List<CustomerBalance> customerBalances = new ArrayList<CustomerBalance>();
	
	CustomerManager customerManager;
	public CustomerBalanceManager() {	 
	 customerBalances.add(new CustomerBalance(1,1,100));
	 customerBalances.add(new CustomerBalance(2,2,200));
	 customerBalances.add(new CustomerBalance(3,3,300));
	 customerBalances.add(new CustomerBalance(4,4,400));
	 customerBalances.add(new CustomerBalance(5,5,500));
	
	}
	
	@Override
	public void add(CreateCustomerBalanceRequest createCustomerBalanceRequest) {
		
		checkCustomerExists(createCustomerBalanceRequest.getCustomerId());
		CustomerBalance customerBalance = new CustomerBalance();
		BeanUtils.copyProperties(createCustomerBalanceRequest,customerBalance );
		customerBalances.add(customerBalance);
	}
	@Override
	public boolean checkCustomerExists(int customerId) {		
		
		return customerManager.checkCustomerId(customerId);
	}
	@Override
	public boolean checkIfBalanceEnough(int customerId,double total) {
		
		for (CustomerBalance customerBalance : customerBalances) {
			
			if(customerBalance.getCustomerId() == customerId) {
				if(customerBalance.getBalance() >= total) {
					return true; 
				}
			}
		}
		throw new BusinesssException("Yetersiz Bakiye ");
	}
}
