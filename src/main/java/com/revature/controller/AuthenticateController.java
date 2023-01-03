package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.UsernamePasswordAuthentication;
import com.revature.service.UserService;

//import io.javalin.http.Context;

@RestController
public class AuthenticateController {
	
	@Autowired
	private UserService userService;

	
	// public void authenticate(Context ctx) {
		
	// 	UsernamePasswordAuthentication loginRequest = ctx.bodyAsClass(UsernamePasswordAuthentication.class);
		
	// 	User u = userService.getUserByUsername(loginRequest.getUsername());
	
	// 	if (u != null && u.getPassword().equals(loginRequest.getPassword())) {
	// 		ctx.sessionAttribute("user", u);
	// 		ctx.status(200);
	// 	} else {
	// 		ctx.status(400);
	// 	}
	// }

	// public void register(Context ctx) {
	// 	/*
	// 	 * There is no code to handle something going wrong, like accidentally trying to create an
	// 	 * account with a username that is already taken. Be aware of this, don't worry about handling
	// 	 * that situation
	// 	 */
	// 	UsernamePasswordAuthentication registerRequest = ctx.bodyAsClass(UsernamePasswordAuthentication.class);

	// 	User newUser = userService.register(registerRequest);

	// 	ctx.json(newUser).status(201);
	// }

	// public void invalidateSession(Context ctx) {
	// 	ctx.req().getSession().invalidate();
	// }
	
	// public boolean verifySession(Context ctx) {	
	// 	return ctx.sessionAttribute("user") != null;
	// }
}
