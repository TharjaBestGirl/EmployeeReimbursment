package com.jack.project1.entities;

public class Reimbursement {
	private int id;
	private int employee_id;
	private int manager_id;
	private String type;
	private int amount;
	private String description;
	private String submit;
	private String resolve;
	private boolean resolved;
	private boolean accepted;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getResolve() {
		return resolve;
	}
	public void setResolve(String resolve) {
		this.resolve = resolve;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employee_id=" + employee_id + ", manager_id=" + manager_id + ", type="
				+ type + ", amount=" + amount + ", description=" + description + ", submit=" + submit + ", resolve="
				+ resolve + ", resolved=" + resolved + ", accepted=" + accepted + "]";
	}
	public Reimbursement(int id, int employee_id, int manager_id, String type, int amount, String description,
			String submit, String resolve, boolean resolved, boolean accepted) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.manager_id = manager_id;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.submit = submit;
		this.resolve = resolve;
		this.resolved = resolved;
		this.accepted = accepted;
	}
	public Reimbursement(int employee_id, String type, int amount, String description) {
		super();
		this.employee_id = employee_id;
		this.type = type;
		this.amount = amount;
		this.description = description;
	}
	public Reimbursement(int employee_id, String type, int amount, String description, String submit, String resolve,
			boolean resolved, boolean accepted) {
		super();
		this.employee_id = employee_id;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.submit = submit;
		this.resolve = resolve;
		this.resolved = resolved;
		this.accepted = accepted;
	}
	public Reimbursement(int id, int employee_id, String type, int amount, String description) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.type = type;
		this.amount = amount;
		this.description = description;
	}
	public Reimbursement() {
		super();
	}
	
}
