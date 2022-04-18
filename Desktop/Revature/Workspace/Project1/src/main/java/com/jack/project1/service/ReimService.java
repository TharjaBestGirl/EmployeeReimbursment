package com.jack.project1.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jack.project1.dao.ReimDAO;
import com.jack.project1.dao.ReimDAOPostgres;
import com.jack.project1.entities.Reimbursement;
import com.jack.project1.handlers.EmployeeController;

public class ReimService implements ReimSInterface{
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	static ReimDAO dao = new ReimDAOPostgres();
	
	public ReimService(ReimDAO dao) {
		logger.debug("Tunaf ish");
        this.dao = dao;
    }
	@Override
	public List<Reimbursement> getAllReimbursements() {
		return this.dao.getAllReimbursements();
	}
	@Override
	public List<Reimbursement> getReimbursementsById(int p) {
		// TODO Auto-generated method stub
		return this.dao.getReimbursementsById(p);
	}
	@Override
	public Reimbursement addReimbursements(int p, Reimbursement r) {
		// TODO Auto-generated method stub
		return this.dao.addReimbursements(p,r);
	}
	@Override
	public Reimbursement updateReimbursements(int p, Reimbursement r) {
		// TODO Auto-generated method stub
		return this.dao.updateReimbursements(p,r);
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		dao.delete(); 
	}

}
