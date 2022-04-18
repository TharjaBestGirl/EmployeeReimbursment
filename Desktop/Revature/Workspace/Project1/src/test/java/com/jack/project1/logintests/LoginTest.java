package com.jack.project1.logintests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jack.project1.dao.EmpDAOPostgres;
import com.jack.project1.dao.ReimDAOPostgres;
import com.jack.project1.entities.Employee;
import com.jack.project1.entities.Reimbursement;
import com.jack.project1.service.EmpSInterface;
import com.jack.project1.service.EmpService;
import com.jack.project1.service.ReimSInterface;
import com.jack.project1.service.ReimService;


public class LoginTest {
	private static EmpSInterface service = new EmpService(new EmpDAOPostgres());
	
    private static Employee testLogin1 = null;
    private static Employee testLogin2 = null;
    
    @Test
    @Order(1)
    void testLoginEmployee() {
        System.out.println("Set Up (one time)");
        Employee e1 = new Employee(1,"Employee","12345",false);
        testLogin1 = service.login(e1);
        
        Assertions.assertEquals(1, testLogin1.getId());
    }
    
    @Test
    @Order(2)
    void testLoginMan() {
        Employee e2 = new Employee(2,"Manager","abcde",true);
        testLogin2 = service.login(e2);
        
        Assertions.assertEquals(2, testLogin2.getId());
    }
}
