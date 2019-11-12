package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
private int customerId;
private String CustomerFirstName;
private String CustomerLastName;
private String CustomerEmail;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerFirstName() {
	return CustomerFirstName;
}
public void setCustomerFirstName(String customerFirstName) {
	CustomerFirstName = customerFirstName;
}
public String getCustomerLastName() {
	return CustomerLastName;
}
public void setCustomerLastName(String customerLastName) {
	CustomerLastName = customerLastName;
}
public String getCustomerEmail() {
	return CustomerEmail;
}
public void setCustomerEmail(String customerEmail) {
	CustomerEmail = customerEmail;
}
}
