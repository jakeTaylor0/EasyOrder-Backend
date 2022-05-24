package com.dnd.eorderservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Order")
@Table(name = "eo_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "orderDetails")
	private String orderDetails;
	
	@Column(name = "dueDate")
	private Date dueDate;
	
	@Column(name = "orderTakenBy")
	private String orderTakenBy;
	
	@Column(name = "assignedTo")
	private Employee assignedTo;
	
	@Column(name = "status")
	private String status;

	public Order(long id, int customerId, String orderDetails, Date dueDate, String orderTakenBy, Employee assignedTo,
			String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderDetails = orderDetails;
		this.dueDate = dueDate;
		this.orderTakenBy = orderTakenBy;
		this.assignedTo = assignedTo;
		this.status = status;
	}

	public Order(long id, int customerId, String orderDetails, Date dueDate, String orderTakenBy, String status) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderDetails = orderDetails;
		this.dueDate = dueDate;
		this.orderTakenBy = orderTakenBy;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getOrderTakenBy() {
		return orderTakenBy;
	}

	public void setOrderTakenBy(String orderTakenBy) {
		this.orderTakenBy = orderTakenBy;
	}

	public Employee getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", orderDetails=" + orderDetails + ", dueDate="
				+ dueDate + ", orderTakenBy=" + orderTakenBy + ", assignedTo=" + assignedTo + ", status=" + status
				+ "]";
	}
	
}
