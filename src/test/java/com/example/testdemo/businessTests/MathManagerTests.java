package com.example.testdemo.businessTests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.testdemo.business.concretes.MathManager;

public class MathManagerTests {
	private MathManager mathManager;

	@BeforeEach // cok kullanilir
	public void setup() {
		mathManager = new MathManager();
	}
	//mocking
	
	@Test
	public void one_plus_seven_is_eight() {
		
		//arrange//given gereklilikler
		
		
		int number1 = 1;
		int number2 = 7;
		int expected = 8;		
		
		//act//when aksiyon alma durumu 
		
		int actual = mathManager.add(number1, number2);
		
		//assert//then
		
		Assertions.assertEquals(expected, actual);		
	}
	
	@Test
	public void minus_one_plus_seven_is_six() {
		
		//arrange//given gereklilikler
		
		
		int number1 = -1;
		int number2 = 7;
		int expected = 6;		
		
		//act//when aksiyon alma durumu 
		
		int actual = mathManager.add(number1, number2);
		
		//assert//then
		
		Assertions.assertEquals(expected, actual);		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,5,8})
	//@CsvSource({"2,5","4,8","3,7"})    // ikili kaynak için 
	public void multiply_with_zero_should_return_zero(int sourceItem) {
		int number1 = 0; 
		int number2 = sourceItem;
		int expected = 0;
		
		int actual = mathManager.multiply(number1, number2);
		
		Assertions.assertEquals(expected, actual);
		
	}
}
