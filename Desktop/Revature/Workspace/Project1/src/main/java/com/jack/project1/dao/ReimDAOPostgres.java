package com.jack.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jack.project1.entities.Reimbursement;
import com.jack.project1.utils.ConnUtil;

public class ReimDAOPostgres implements ReimDAO{
	
	private static final Logger logger = LogManager.getLogger(ReimDAOPostgres.class);
	static Connection conn = ConnUtil.getInstance();

	@Override
	public List<Reimbursement> getAllReimbursements() {
		logger.debug("Getting all reimbursements");
		// TODO Auto-generated method stub
		Reimbursement s;
		ArrayList<Reimbursement> sList = new ArrayList<Reimbursement>();
		try { 
			PreparedStatement prpst = conn.prepareStatement("select * from reimbursements");
			ResultSet rs = prpst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int emp = rs.getInt("emp_id");
				int man = rs.getInt("man_id");
				String type = rs.getString("type");
				int amount = rs.getInt("amount"); 
				String description = rs.getString("description");
				String submit = rs.getString("submit");
				String resolve = rs.getString("resolve_time");
				boolean resolved = rs.getBoolean("resolved");
				boolean accepted = rs.getBoolean("accepted");
				s = new Reimbursement(id,emp,man,type,amount,description,submit,resolve,resolved,accepted);
				sList.add(s);
			}
		} catch (SQLException e) {
			logger.error("Failed to get all reimbursements");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Finished getting all reimbursements");
		return sList;
	}

	@Override
	public List<Reimbursement> getReimbursementsById(int p) {
		logger.debug("getting reimbursement for employee id "+p);
		// TODO Auto-generated method stub
		Reimbursement s;
		ArrayList<Reimbursement> sList = new ArrayList<Reimbursement>();
		try { 
			PreparedStatement prpst = conn.prepareStatement("select * from reimbursements where emp_id=?");
			prpst.setInt(1, p);
			ResultSet rs = prpst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int emp = rs.getInt("emp_id");
				int man = rs.getInt("man_id");
				String type = rs.getString("type");
				int amount = rs.getInt("amount"); 
				String description = rs.getString("description");
				String submit = rs.getString("submit");
				String resolve = rs.getString("resolve_time");
				boolean resolved = rs.getBoolean("resolved");
				boolean accepted = rs.getBoolean("accepted");
				s = new Reimbursement(id,emp,man,type,amount,description,submit,resolve,resolved,accepted);
				sList.add(s);
			}
		} catch (SQLException e) {
			logger.error("Failed to get reimbursements");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Finished getting reimbursements");
		return sList;
	}

	@Override
	public Reimbursement addReimbursements(int p, Reimbursement r) {
		logger.debug("adding reimbursement for employee id "+p+""+r.toString());
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptsmt = conn.prepareStatement("insert into reimbursements(emp_id, type, amount, description) values (?,?,?,?)");
			ptsmt.setInt(1,p);
			ptsmt.setString(2,r.getType());
			ptsmt.setInt(3,r.getAmount());
			ptsmt.setString(4,r.getDescription());
			ptsmt.execute();
			ptsmt.close();
			
		}
		catch (SQLException e){
			logger.error("Failed to add reimbursements");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement updateReimbursements(int p, Reimbursement r) {
		logger.debug("updating reimbursement for case id "+p+""+r.toString());
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnUtil.getInstance();
			PreparedStatement ptsmt = conn.prepareStatement("update reimbursements set man_id=?, accepted=?,resolved=?, resolve_time = ?::date  where id=?");
			ptsmt.setInt(1,p);
			ptsmt.setBoolean(2,r.isAccepted());
			ptsmt.setBoolean(3,true);
			Date date = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	        String str = formatter.format(date);
			ptsmt.setString(4, str);
			ptsmt.setInt(5,r.getId());
			ptsmt.execute();
			ptsmt.close();
		}
		catch(SQLException e) {
			logger.error("Failed to update reimbursements");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	@Override
	public void delete() {
		try {
			PreparedStatement ptsmt = conn.prepareStatement("delete from reimbursements where type='test'");
			ptsmt.execute();
		}
		catch (SQLException e) {
			
		}
	}
}
