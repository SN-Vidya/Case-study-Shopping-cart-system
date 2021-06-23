package com.shoppingcartsystem.profileservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.profileservice.model.User;



@Repository
public interface UserRepository extends MongoRepository<User,String> {

	

	

	User findByFullName(String fullName);

	List<User> findByFullNameContaining(String fullName);

	User findByEmail(String username);

	
	
	
}
