package com.shoppingcartsystem.profileservice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String fullName) {
	  try {
	    List<User> users = new ArrayList<User>();

	    if (fullName == null)
	      userRepository.findAll().forEach(users::add);
	    else
	      userRepository.findByFullNameContaining(fullName).forEach(users::add);

	    if (users.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(users, HttpStatus.OK);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}

	@GetMapping("/user/{_id}")
	public ResponseEntity<User> getUserById(@PathVariable("_id") String _id) {
	  Optional<User> userData = userRepository.findById(_id);

	  if (userData.isPresent()) {
	    return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	 
	
	@PutMapping("/update/{_id}")
	public ResponseEntity<User> updateUser(@PathVariable("_id") String _id, @RequestBody User user) {
	  Optional<User> userData = userRepository.findById(_id);

	  if (userData.isPresent()) {
	    User _user = userData.get();
	    _user.setFullName(user.getFullName());
	    _user.setEmail(user.getEmail());
	    _user.setGender(user.getGender());
	    return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}

	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
	  try {
	    User _user = userRepository.save(new User(user.get_id(), user.getFullName(), user.getEmail(),user.getGender(), user.getDob(), user.getRole(), user.getMobile_no(), user.getPassword(), user.getAddress()));
	    return new ResponseEntity<>(_user, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	

	@DeleteMapping("/delete/{_id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("_id") String _id) {
	  try {
	    userRepository.deleteById(_id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}


}