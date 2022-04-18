package com.jack.project1.dao;

import java.util.List;

import com.jack.project1.entities.Employee;

public interface EmpDAO {
	List<Employee> getAllLogins();
	Employee login (Employee empObj);
}
