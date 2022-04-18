package com.jack.project1.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jack.project1.dao.EmpDAOPostgres;
import com.jack.project1.dao.ReimDAOPostgres;
import com.jack.project1.entities.Employee;
import com.jack.project1.entities.Reimbursement;
import com.jack.project1.service.EmpSInterface;
import com.jack.project1.service.EmpService;
import com.jack.project1.service.ReimSInterface;
import com.jack.project1.service.ReimService;
import com.jack.project1.utils.ConnUtil;

import io.javalin.http.Handler;

public class EmployeeController {
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	static EmpSInterface service = new EmpService(new EmpDAOPostgres());
	static ReimSInterface rservice = new ReimService(new ReimDAOPostgres());
	
	public static Handler getAllEmployeesHandler = ctx -> {
		logger.debug("Getting all logins");
		List<Employee> cList = service.getAllLogins();
		ctx.json(cList);
	};
	
	public static Handler loginHandler = ctx -> {
		logger.debug("logging in");
		Employee empObj = ctx.bodyAsClass(Employee.class);
		Employee login = service.login(empObj);
		System.out.println(login);
		logger.info(login);
		ctx.sessionAttribute("CUID", login.getId());
		ctx.json(login);
		ctx.status(200);
	};
	
	public static Handler addReimHandler = ctx -> {
		logger.debug("Adding reimbursement");
		int p = ctx.sessionAttribute("CUID");
		Reimbursement reimObj = ctx.bodyAsClass(Reimbursement.class);
		Reimbursement added = rservice.addReimbursements(p, reimObj);
		System.out.println(added);
		logger.info(added);
		ctx.status(201);
	};
	
	public static Handler updateReimHandler = ctx -> {
		logger.debug("updating reimbursement");
		int p = ctx.sessionAttribute("CUID");
		Reimbursement reimObj = ctx.bodyAsClass(Reimbursement.class);
		Reimbursement updated = rservice.updateReimbursements(p, reimObj);
		ctx.status(201);
		System.out.println(updated);
		logger.info(updated);
	};

	public static Handler getAllReimbursements = ctx -> {
		logger.debug("Getting all reimbursement");
		List<Reimbursement> rList = rservice.getAllReimbursements();
		ctx.json(rList);
	};

	public static Handler getReimbursementsById = ctx -> {
		logger.debug("Getting reimbursement by id");
		int p = ctx.sessionAttribute("CUID");
		List<Reimbursement> rList = rservice.getReimbursementsById(p);
		ctx.json(rList);
	};
}

