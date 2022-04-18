package com.jack.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.jack.project1.entities.Employee;
import com.jack.project1.utils.ConnUtil;

public class EmpDAOPostgres implements EmpDAO{
	
	private static final Logger logger = LogManager.getLogger(EmpDAOPostgres.class);
	
	static Connection conn = ConnUtil.getInstance();
	
	@Override
	public List<Employee> getAllLogins() {
		logger.debug("Getting all Logins");
		// TODO Auto-generated method stub
		// Write logic to access your database here.
		Employee s;
		ArrayList<Employee> sList = new ArrayList<Employee>();
		try { 
			PreparedStatement prpst = conn.prepareStatement("select * from logins");
			ResultSet rs = prpst.executeQuery();
			while (rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String pass = rs.getString("pass");
			Boolean man = rs.getBoolean("manager");
			s = new Employee(id,username, pass, man);
			sList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Failed to get all Logins");
			e.printStackTrace();
		}
		logger.debug("Finished getting all Logins");
		return sList;
	}

	@Override
	public Employee login(Employee empObj) {
		logger.debug("Logging in employee "+empObj.getUsername());
		// TODO Auto-generated method stub
		Employee localEmp = new Employee();
		try {
			PreparedStatement prpst = conn.prepareStatement("select * from logins");
			ResultSet rs = prpst.executeQuery();
			String empUser = empObj.getUsername();
			String empPass = empObj.getPassword();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String pass = rs.getString("pass");
				boolean manager = rs.getBoolean("manager");
				if (empUser.equals(user) && empPass.equals(pass)) {
					localEmp.setId(id);
					localEmp.setUsername(user);
					localEmp.setPassword(pass);
					localEmp.setManager(manager);
					break;
				}
			}
		}
		catch (SQLException e) {
			logger.error("Failed to log in an Employee");
			e.printStackTrace();
		}
		logger.debug("Finished logging in an Employee");
		return localEmp;
	}
	
}
