package com.shoppingcartsystem.profileservice.service;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcartsystem.profileservice.model.User;
import com.shoppingcartsystem.profileservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}
	
	@Override
	 public Optional<User> getById(String _id) {
	  
	  return userRepository.findById(_id); }
	  
	 
	  @Override public User getByFullName(String fullName) {
	  
	  return userRepository.findByFullName(fullName); 
	  
	  }
	  
	  
	@Override
	  public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	 
	@Override
	public User updateProfile(User user) {
		
		return userRepository.save(user);
	}
	@Override
	public User addNewUser(User user) {
		return userRepository.save(user);
	}
	
	



}