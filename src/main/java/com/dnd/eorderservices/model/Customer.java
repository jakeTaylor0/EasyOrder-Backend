package com.dnd.eorderservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "eo_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstName")
	private String fistName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;

	public Customer() {
		super();
	}
	
	public Customer(String fistName, String lastName, String phone) {
		super();
		this.fistName = fistName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fistName=" + fistName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
}
