package com.shoppingcartsystem.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcartsystem.profileservice.model.User;

public interface UserService {
	
	Optional<User> getById(String _id );

	List<User> getAllUser();
	
	User addNewCustomerProfile(User user);
	
	User addAdminProfile(User user);

	User getByFullName(String fullName);

	User updateProfile(User user);

	User deleteByFullName(String fullName);

	
	

}
