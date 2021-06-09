package com.shoppingcartsystem.profileservice.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.profileservice.model.User;
import com.shoppingcartsystem.profileservice.repository.UserRepository;


@RestController
@RequestMapping("/profile-service")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/allusers")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}
	@GetMapping("/allusers/{_id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<User> getById( @PathVariable String _id) {
		
		return userRepository.findById(_id);
	}

	/*
	 * @GetMapping("/allusers/{fullName}")
	 * 
	 * @ResponseStatus(HttpStatus.FOUND) public User
	 * getByFullName(@RequestParam(value="fullName") String fullName) {
	 * 
	 * return userRepository.findByFullName(fullName); }
	 */
	@PutMapping("/update/{_id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public User updateProfile(@RequestBody User user, @PathVariable String _id) {
		
		user.set_id(_id);
		userRepository.save(user);
		return user;
	}
	@PostMapping("/customerRegistration")
	public String addNewCustomerProfile(@RequestBody User user) {
		
		userRepository.save(user);
		return "A new Customer is added";
	}
	@PostMapping("/addAdmin")
	public String addAdminProfile(@RequestBody User user) {
		
		userRepository.save(user);
		return "Admin Profile is added";
	}
	@DeleteMapping("/delete/{_id}")
	public String deleteById(@PathVariable String  _id) {
		
		userRepository.deleteById(_id);
		return "User Deleted with an Id: " + _id;
	}

}