package com.billsbars.app.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.billsbars.app.model.BarOfSoap;


public interface SoapBarsRepository extends MongoRepository<BarOfSoap, String> {

	BarOfSoap findBySoapNameAndBarTypeAndBaseTypeAndScent(String SoapName,String barType, String baseType,String scent);

	BarOfSoap findBySoapName(String soapName);
}