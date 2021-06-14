package com.shoppingcartsystem.websitecontroller.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository

;

import org.springframework.stereotype.Repository;
import com.shoppingcartsystem.websitecontroller.model.User;



@Repository
public interface UserRepository extends MongoRepository<User,String> {
	
	//User findByMobile_no(Double mobile_no);
	User findByFullName(String fullName);
//
//	User deleteByFullName(String fullName);
//
//	void get(String anyString);
//
//	User getOne(String _id);
//	
//	

}
