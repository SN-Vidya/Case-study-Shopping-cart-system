package com.shoppingcartsystem.profileservice.service;
import java.util.List;

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
    public User getUserById(String _id ) {
        return userRepository.getOne(_id);
    }

	/*
	 * @Override public Optional<User> getById(String _id) {
	 * 
	 * return userRepository.findById(_id); }
	 * 
	 */
	  @Override public User getByFullName(String fullName) {
	  
	  return userRepository.findByFullName(fullName); }
	 
	@Override
	public User updateProfile(User user) {
		
		return userRepository.save(user);
	}
	@Override
	public User addNewCustomerProfile(User user) {
		return userRepository.save(user);
	}
	@Override
	public User addAdminProfile(User user) {
		return userRepository.save(user);
	}
	@Override
	public User deleteByFullName(String fullName) {
		return userRepository.deleteByFullName(fullName);
	}
	
	
	

}
