package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.CustomerDAO;
import com.project.model.Customer;

import Exception.CustomerNotFoundException;
@Component
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	public Customer addCustomer(Customer customer) {
	return customerDAO.save(customer);
	}
//	customer.setCustomerId(customerIdCount);
//	customerList.add(customer);
//	customerList.add(customer);
//	customerIdCount++;
//	return customer;

public List<Customer> getCustomers(){
	return (List<Customer>) customerDAO.findAll();
}
//	return customerList;

public Customer getCustomer(int customerId) {
	Optional<Customer> optionalcustomer= customerDAO.findById(customerId);
	if(!optionalcustomer.isPresent())
   throw new CustomerNotFoundException("Customer Record is not available....");
		return  customerDAO.findById(customerId).get();
	
	}

//	return customerList
//			.stream()
//			.filter(c->c.getCustomerId()==customerId)
//			.findFirst()
//			.get();
	
public Customer updateCustomer(int customerId, Customer customer){
	customer.setCustomerId(customerId);
	return customerDAO.save(customer);
	}
//	customerList
//	.stream()
//	.forEach(c->{
//			if(c.getCustomerId()==customerId) {
//			c.setCustomerFirstName(customer.getCustomerFirstName());
//			c.setCustomerLastName(customer.getCustomerLastName());
//			c.setCustomerEmail(customer.getCustomerEmail());	
//			}
//	});  
//	return customerList
//			.stream()
//			.filter(c->c.getCustomerId()==customerId)
//			.findFirst()
//			.get();



}
