package com.jack.project1.entities;

public class Employee {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String username;
	private String password;
	private boolean manager;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", manager=" + manager
				+ "]";
	}
	public Employee(int id, String username, String password, boolean manager) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.manager = manager;
	}
	public Employee() {
		super();
	}
}
