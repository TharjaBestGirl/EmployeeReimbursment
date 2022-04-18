package com.jack.project1.app;

import java.sql.Connection;

import com.jack.project1.handlers.EmployeeController;
import com.jack.project1.utils.ConnUtil;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainApp {
	public static void main(String[] args) {
		Javalin app = Javalin.create(ctx-> {ctx.enableCorsForAllOrigins(); ctx.addStaticFiles("website", Location.CLASSPATH);}).start();
		
		app.post("/", EmployeeController.getAllEmployeesHandler);
		
		app.post("/login", EmployeeController.loginHandler);
		
		app.post("/addreim", EmployeeController.addReimHandler);
		
		app.put("/updatereim", EmployeeController.updateReimHandler);
		
		app.get("/reim", EmployeeController.getAllReimbursements);
		
		app.get("/reimid/", EmployeeController.getReimbursementsById);
		
		Connection conn = ConnUtil.getInstance();
		Connection conn2 = ConnUtil.getInstance();
		System.out.println(conn);
		System.out.println(conn2);
	}
}
