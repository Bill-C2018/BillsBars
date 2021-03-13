package com.billsbars.app.service;

import java.util.List;

import com.billsbars.app.model.CustomerModel;

public interface CustomerService {
	
	CustomerModel createCustomer(CustomerModel customer);
	
	CustomerModel editCustomer(CustomerModel customer);
	
	boolean deleteCustomer(CustomerModel customer);
	
	List<CustomerModel> getAllCustomers();
	
	CustomerModel getOneCustomer(String userName);
	
	CustomerModel checkCustomerLogin(String userName, String pword);

}
