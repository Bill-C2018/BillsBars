package com.billsbars.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.billsbars.app.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
	
	Optional<Inventory> findByBarOfSoapId(String id);
}
