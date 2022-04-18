package com.jack.project1.reimbursementtests;

import org.junit.jupiter.api.Order;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jack.project1.dao.ReimDAOPostgres;
import com.jack.project1.entities.Employee;
import com.jack.project1.entities.Reimbursement;
import com.jack.project1.service.ReimSInterface;
import com.jack.project1.service.ReimService;

public class ReimburseTest {
	private static ReimSInterface rservice = new ReimService(new ReimDAOPostgres());

    private static Reimbursement testReimbursement1 = null;
    private static Reimbursement testReimbursement2 = null;
    
	private static List<Reimbursement> testList1 = null;
    
	@BeforeAll
	static void setUpOnce() {
		
	}

    @Test
    @Order(2)
    void addReimbursement() {
    	Reimbursement r1 = new Reimbursement(200,1,"test",15,"test");
    	testReimbursement1 = rservice.addReimbursements(1, r1);
    	
    	Assertions.assertEquals(200, testReimbursement1.getId());
    }
    
    @Test
    @Order(1)
    void getAllReimbursement() {
    	List<Reimbursement> testList2 = rservice.getAllReimbursements();
    	Assertions.assertNotEquals(testList1,testList2);
    }
    
    @Test
    @Order(4)
    void updateReimbursement() {
    	Reimbursement r1 = new Reimbursement(203,500,"test",200,"testing");
    	testReimbursement1 = rservice.addReimbursements(500, r1); 	
    	Reimbursement r2 = new Reimbursement(203,500,"test",400,"testing");
    	testReimbursement2 = rservice.updateReimbursements(203, r2);
    	
    	Assertions.assertEquals(400, testReimbursement2.getAmount());
    }
    
    @Test
    @Order(3)
    void getReimbursementByEmployeeId() {
    	Reimbursement r1 = new Reimbursement(201,500,"test",200,"testing");
    	Reimbursement r2 = new Reimbursement(202,500,"test",200,"testing");
    	Reimbursement r3 = new Reimbursement(200,500,"test",200,"testing");
    	rservice.addReimbursements(500, r1);
    	rservice.addReimbursements(500, r2);
    	rservice.addReimbursements(500, r3);
    	
    	List<Reimbursement> r4 = rservice.getReimbursementsById(500);
    	
    	Assertions.assertEquals(3, r4.size());
    	
    }
    
    @AfterAll
    static void deleteAll() {
    	rservice.delete();
    }
}
