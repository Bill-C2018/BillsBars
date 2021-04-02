package com.billsbars.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billsbars.app.DuplicateRecordException;
import com.billsbars.app.dao.LocalCustomersRepository;
import com.billsbars.app.model.CustomerModel;

@Service("CustomerServiceImpLocal")
public class CustomerServiceImpLocal implements CustomerService {
	
	@Autowired
	private LocalCustomersRepository customerRepository;

	@Override
	public CustomerModel createCustomer(CustomerModel customer) {
		CustomerModel exists = customerRepository.findByUserName(customer.getUserName());
		if (exists != null) {
			throw new DuplicateRecordException("That name is already taken");
		}
		customerRepository.save(customer);
		exists = customerRepository.findByUserName(customer.getUserName());
		return exists;
	}

	@Override
	public CustomerModel editCustomer(CustomerModel customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(CustomerModel customer) {
		CustomerModel exists = customerRepository.findByUserName(customer.getUserName());
		if (exists != null) {
			customerRepository.deleteById(exists.getId());
			return true;
		}
		return false;
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerModel getOneCustomer(String userName) {
		return customerRepository.findByUserName(userName);
	}
	
	public CustomerModel checkCustomerLogin(String userName, String pword) {
		return customerRepository.findByUserNameAndUserPword(userName, pword);
	}

}
