package com.shoppingcartsystem.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.profileservice.model.User;



@Repository
public interface UserRepository extends MongoRepository<User,String> {

	

	

	User deleteByFullName(String fullName);

	User findByFullName(String fullName);

	
	
	
}
