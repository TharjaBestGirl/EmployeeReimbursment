package com.jack.project1.service;

import java.util.List;

import com.jack.project1.entities.Employee;

public interface EmpSInterface {

	List<Employee> getAllLogins();
	Employee login(Employee empObj);

}
