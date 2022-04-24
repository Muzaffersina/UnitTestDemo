package com.example.testdemo.businessTests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.example.testdemo.business.concretes.StudentManager;
import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.Student;

public class StudentManagerTests {
	
	StudentManager studentManager;
	
	@BeforeEach // cok kullanilir
	public void setup() {
		studentManager = new StudentManager();
	}
	
	@AfterEach // cok nadiren kullanilir
	public void cleanup() {
		
	}
	/*
	@BeforeAll // en basta bir kere 
	public void initialize() {
		
	}
	
	@AfterAll // en son bir kere
	public void finish() {
		
	}
	
	*/

	@Test
	public void student_can_not_be_duplicated_by_name() {
		
		Student student = new Student();
		student.setName("isim1");
		student.setId(6);
		
		Executable executable = () -> studentManager.add(student);
		
		assertThrows(BusinesssException.class, executable);
	}
}
