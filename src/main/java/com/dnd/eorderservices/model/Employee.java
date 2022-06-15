package com.dnd.eorderservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name = "eo_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	public Employee() {
		super();
	}
	
	public Employee(long employeeId, String name, String userName, String email, String password) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public long getEmployeeId() {
		return employeeId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + "]";
	}
}
