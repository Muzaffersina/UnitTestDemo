package com.example.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.testdemo.business.abstracts.CustomerService;
import com.example.testdemo.business.request.create.CreateCustomerRequest;
import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.Customer;
@Service
public class CustomerManager implements CustomerService {
	
	public List<Customer> customers = new ArrayList<Customer>() ;

	public CustomerManager() {
		
		customers.add(new Customer(1,"Ali","soyad1"));
		customers.add(new Customer(2,"Veli","soyad2"));
		customers.add(new Customer(3,"Mehmet","soyad3"));
		customers.add(new Customer(4,"Arda","soyad4"));
		customers.add(new Customer(5,"Ziya","soyad5"));
	}
	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(createCustomerRequest,customer );
		customers.add(customer);
	}
	@Override
	public boolean checkCustomerId(int customerId) {
		
		for (Customer checkCustomer : customers) {
			if(checkCustomer.getId() == customerId ) {
				return true;				
			}
		}
		throw new BusinesssException("Bu müşteri mevcut değil");		
	}

}
