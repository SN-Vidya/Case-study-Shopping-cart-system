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
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcartsystem.profileservice.model.User;
import com.shoppingcartsystem.profileservice.repository.UserRepository;



@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{_id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<User> getById( @PathVariable String _id) {
		
		return userRepository.findById(_id);
	}

	
	  @GetMapping("userName/{fullName}")
	  
	  @ResponseStatus(HttpStatus.FOUND) public User
	  getByFullName(@RequestParam(value="fullName", required = false) String fullName) {
	  
	  return userRepository.findByFullName(fullName); }
	  
 @GetMapping("profile/{email}")
	  
	  @ResponseStatus(HttpStatus.FOUND) public User
	  getByEmail(@RequestParam(value="email", required = false) String email) {
	  
	  return userRepository.findByEmail(email); }
	 
	 
	@PutMapping("/update/{email}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public User updateProfile(@RequestBody User user, @PathVariable String email) {
		
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}
	@PostMapping("/Register")

	public String addNewCustomerProfile(@RequestBody User user) {
		
		userRepository.save(user);
		return "A new User is added";
	}
	
	@DeleteMapping("/delete/{_id}")
	public String deleteById(@PathVariable String  _id) {
		
		userRepository.deleteById(_id);
		return "User Deleted with an Id: " + _id;
	}

}