package com.jack.project1.service;

import java.util.List;

import com.jack.project1.entities.Reimbursement;

public interface ReimSInterface {
	List<Reimbursement> getAllReimbursements();

	List<Reimbursement> getReimbursementsById(int p);
	
	Reimbursement addReimbursements(int p, Reimbursement r);
	
	Reimbursement updateReimbursements(int p, Reimbursement r);

	void delete();
}
