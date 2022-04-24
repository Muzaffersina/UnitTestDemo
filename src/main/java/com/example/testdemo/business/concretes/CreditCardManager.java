package com.example.testdemo.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.testdemo.business.abstracts.CreditCardService;
import com.example.testdemo.business.request.create.CreateCreditCardRequest;
import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.CreditCard;
@Service
public class CreditCardManager implements CreditCardService{
	
	public List<CreditCard> creditCards = new ArrayList<CreditCard>();

	public CreditCardManager() {
		creditCards.add(new CreditCard("Ali soyad1","123456789101","111","0622"));
	}
	@Override
	public void add(CreateCreditCardRequest createCreditCardRequest) {
		
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(createCreditCardRequest,creditCard );
		creditCards.add(creditCard);
	}

	@Override
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
	
}
