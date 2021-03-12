package com.billsbars.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billsbars.app.model.CustomerModel;

@Service("CustomerServiceImpLocal")
public class CustomerServiceImpLocal implements CustomerService {

	@Override
	public CustomerModel createCustomer(CustomerModel customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerModel editCustomer(CustomerModel customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(CustomerModel customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerModel getOneCustomer(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
