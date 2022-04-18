package com.jack.project1.service;

import java.util.List;

import com.jack.project1.dao.EmpDAO;
import com.jack.project1.dao.EmpDAOPostgres;
import com.jack.project1.entities.Employee;

public class EmpService implements EmpSInterface {
	static EmpDAO dao = new EmpDAOPostgres();
	
	public EmpService(EmpDAO dao) {
        this.dao = dao;
    }

	@Override
	public Employee login(Employee empObj) {
		// TODO Auto-generated method stub
		return this.dao.login(empObj);
	}

	@Override
	public List<Employee> getAllLogins() {
		// TODO Auto-generated method stub
		return this.dao.getAllLogins();
	}
}
