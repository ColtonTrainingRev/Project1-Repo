package com.revature.controller;

//import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Moon;
//import com.revature.models.Planet;
//import com.revature.models.User;
import com.revature.service.MoonService;

//import io.javalin.http.Context;

@RestController
public class MoonController {
	
	@Autowired
	private MoonService mService;

	@GetMapping("/api/moon/id/{id}")
	public ResponseEntity<Moon> getMoonById(@PathVariable int id){
		return new ResponseEntity<>(this.mService.getMoonById(id), HttpStatus.OK);
	}

	@GetMapping("/api/moon/{name}")
	public ResponseEntity<Moon> getMoonByName(@PathVariable String name){
		return new ResponseEntity<>(this.mService.getMoonByName(name), HttpStatus.OK);
	}

	@GetMapping("/api/moon")
	public ResponseEntity<List<Moon>> getAllMoons(){
		return new ResponseEntity<>(this.mService.getAllMoons(), HttpStatus.OK);
	}

	@PostMapping("/api/moon")
	public ResponseEntity<String> createMoon(@RequestBody Moon moon){
		return new ResponseEntity<>(this.mService.createMoon(moon), HttpStatus.CREATED);
	}

	@DeleteMapping("/api/moon/{id}")
	public ResponseEntity<String> deleteMoonById(@PathVariable int id){
		return new ResponseEntity<>(this.mService.deleteMoon(id), HttpStatus.OK);
	}

	// @PatchMapping("/api/moon")
	// public ResponseEntity<String> updateMoon(@RequestBody Moon moon){
	// 	return new ResponseEntity<>(this.mService.updateMoon(moon.getName(), moon.getId()), HttpStatus.OK);
	// }
	
}

/*
	public void getAllMoons(Context ctx) throws SQLException {
	public void createMoon(Context ctx) {
	public void deleteMoon(Context ctx) {
	public void getPlanetMoons(Context ctx) throws SQLException {
 * 
 */

/*
 public void getAllMoons(Context ctx) throws SQLException {
		
		ctx.json(mService.getAllMoons()).status(200);
	}

	public void getMoonByName(Context ctx) {
		
		User u = ctx.sessionAttribute("user");
		String moonName = ctx.pathParam("name");
		
		Moon m = mService.getMoonByName(u.getUsername(), moonName);
		
		ctx.json(m).status(200);
	}

	public void getMoonById(Context ctx) {
		
		User u = ctx.sessionAttribute("user");
		int moonId = ctx.pathParamAsClass("id", Integer.class).get();
		
		Moon m = mService.getMoonById(u.getUsername(), moonId);
		
		ctx.json(m).status(200);
	}

	public void createMoon(Context ctx) {
		
		Moon m = ctx.bodyAsClass(Moon.class);
		User u = ctx.sessionAttribute("user");
		
		Moon outGoingMoon = mService.createMoon(u.getUsername(),m);
		
		ctx.json(outGoingMoon).status(201);
	}

	public void deleteMoon(Context ctx) {
		
		int moonId = ctx.pathParamAsClass("id", Integer.class).get();
		
		mService.deleteMoonById(moonId);
		
		ctx.json("Moon successfully deleted").status(202);
	}
	
	public void getPlanetMoons(Context ctx) throws SQLException {
		
		int planetId = ctx.pathParamAsClass("id", Integer.class).get();
		
		List<Moon> moonList = mService.getMoonsFromPlanet(planetId);
		
		ctx.json(moonList).status(200);
	}
 */