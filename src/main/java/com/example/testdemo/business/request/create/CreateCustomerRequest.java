package com.example.testdemo.business.request.create;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
	


	private int id;
	private String firstName;
	private String lastName;
}
