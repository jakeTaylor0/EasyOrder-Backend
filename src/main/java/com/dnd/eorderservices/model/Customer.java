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
	private long customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;

	public Customer() {
		super();
	}

	public Customer(long customerId, String name, String phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phone=" + phone + "]";
	}	
}
