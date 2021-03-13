package com.billsbars.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.billsbars.app.model.CustomerModel;

public interface LocalCustomersRepository extends MongoRepository<CustomerModel, String> {
	
	CustomerModel findByUserName(String name);
	CustomerModel findByUserNameAndUserPword(String userName, String pword);

}
