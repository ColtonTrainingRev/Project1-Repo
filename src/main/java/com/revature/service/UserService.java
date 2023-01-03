package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	// public UserService(){
	// 	this.dao = new UserDao();
	// }

	public User getUserByUsername(String username) {
		Optional<User> possibleUser = this.dao.findByUsername(username);
		if(possibleUser.isPresent()) {
			return possibleUser.get();
		} else {
			return new User();
		}
		/*
		 * All this service needs to do is return the data grabbed by the dao object.
		 * That's it: the other parts of the application will handle interpreting what to do with
		 * the user info returned by this particular method
		 */
		//return this.dao.getUserByUsername(username);
	}

	// public User register(UsernamePasswordAuthentication registerRequest) {
	// 	return this.dao.createUser(registerRequest);
	// }

	// public static void main(String[] args) {
	// 	UserService us = new UserService();
	// 	//System.out.println(us.getUserByUsername("Billy"));
	// 	UsernamePasswordAuthentication newUser = new UsernamePasswordAuthentication();
	// 	newUser.setUsername("password");
	// 	newUser.setPassword("username");
	// 	System.out.println(us.register(newUser));
	// }
}
