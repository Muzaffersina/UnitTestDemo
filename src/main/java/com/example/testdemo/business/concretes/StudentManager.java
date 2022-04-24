package com.example.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.example.testdemo.common.exceptions.BusinesssException;
import com.example.testdemo.entities.concretes.Student;

public class StudentManager {

	public List<Student> students = new ArrayList<Student>();

	public StudentManager() {

		students.add(new Student(1, "isim1"));
		students.add(new Student(2, "isim2"));
		students.add(new Student(3, "isim3"));
		students.add(new Student(4, "isim4"));
		students.add(new Student(5, "isim5"));
	}

	// int add(Student)
	// success :1
	// Failure :0

	public void add(Student student) {

		checkIfStudentExists(student);
		students.add(student);	

	}

	private void checkIfStudentExists(Student student) {

		for (Student checkStudent : students) {
			if (student.getName() == checkStudent.getName()) {
				throw new BusinesssException("Bu öğrenci mevcut");
			}
		}
	}

}
