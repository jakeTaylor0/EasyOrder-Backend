package com.dnd.eorderservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "Order")
@Table(name = "eo_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@Column(name = "customerId")
	private long customerId;
	
	@Column(name = "orderDetails")
	private String orderDetails;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "dueDate")
	private String dueDate;
	
	@Column(name = "orderTakenBy")
	private String orderTakenBy;	
	
	@Column(name = "orderTakenTime")
	private String orderTakenTime;
	
	@Column(name = "assignedTo", nullable = true)
	private String assignedTo;
	
	@Column(name = "status")
	private String status;

	public Order() {
		super();
	}

	public Order(long orderId, long customerId, String orderDetails, String dueDate, String orderTakenBy,
			String orderTakenTime, String assignedTo, String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDetails = orderDetails;
		this.dueDate = dueDate;
		this.orderTakenBy = orderTakenBy;
		this.orderTakenTime = orderTakenTime;
		this.assignedTo = assignedTo;
		this.status = status;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getOrderTakenBy() {
		return orderTakenBy;
	}

	public void setOrderTakenBy(String orderTakenBy) {
		this.orderTakenBy = orderTakenBy;
	}

	public String getOrderTakenTime() {
		return orderTakenTime;
	}

	public void setOrderTakenTime(String orderTakenTime) {
		this.orderTakenTime = orderTakenTime;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
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
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDetails=" + orderDetails
				+ ", dueDate=" + dueDate + ", orderTakenBy=" + orderTakenBy + ", orderTakenTime=" + orderTakenTime
				+ ", assignedTo=" + assignedTo + ", status=" + status + "]";
	}

}
