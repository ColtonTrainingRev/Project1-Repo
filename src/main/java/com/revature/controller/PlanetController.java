package com.revature.controller;

// import java.sql.SQLException;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.AuthenticationFailed;
import com.revature.exceptions.EntityNotFound;
// import com.revature.models.Moon;
import com.revature.models.Planet;
// import com.revature.models.User;
// import com.revature.service.MoonService;
import com.revature.service.PlanetService;

// import io.javalin.http.Context;
// import io.javalin.validation.Validator;

@RestController
public class PlanetController {
	
	private static Logger teamLogger = LoggerFactory.getLogger(PlanetController.class);

	@Autowired
	private PlanetService pService;

	@ExceptionHandler(AuthenticationFailed.class)
    public ResponseEntity<String> authenticationFailed(AuthenticationFailed e){
        teamLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e){
        teamLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<String> sqlIssue(PSQLException e){
        teamLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> deleteFailed(EmptyResultDataAccessException e){
        teamLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>("could not delete team", HttpStatus.BAD_REQUEST);
    }

	@GetMapping ("/api/planet/id/{id}")
	public ResponseEntity<Planet> getPlanetById(@PathVariable int id){
		return new ResponseEntity<>(this.pService.getPlanetById(id), HttpStatus.OK);
	}

	@GetMapping("/api/planet/{name}")
	public ResponseEntity<Planet> getPlanetByName(@PathVariable String name){
		return new ResponseEntity<>(this.pService.getPlanetByName(name), HttpStatus.OK);
	}

	@GetMapping("/api/planet")
	public ResponseEntity<List<Planet>> getAllPlanets(){
		return new ResponseEntity<>(this.pService.getAllPlanets(), HttpStatus.OK);
	}
	
	@PostMapping("/api/planet")
	public ResponseEntity<String> createPlanet(@RequestBody Planet planet){
		return new ResponseEntity<>(this.pService.createPlanet(planet), HttpStatus.CREATED);
	}

	@DeleteMapping("/api/planet/{id}")
	public ResponseEntity<String> deletePlanetById(@PathVariable int id){
		return new ResponseEntity<>(this.pService.deletePlanet(id), HttpStatus.OK);
	}
}

/*
 public void getAllPlanets(Context ctx) throws SQLException {
		
		ctx.json(pService.getAllPlanets()).status(200);
	}

	public void getPlanetByName(Context ctx) {
		
		User u = ctx.sessionAttribute("user");
		String planetName = ctx.pathParam("name");
		
		Planet p = pService.getPlanetByName(u.getUsername(), planetName);
		
		ctx.json(p).status(200);
	}

	public void getPlanetByID(Context ctx) {
		
		User u = ctx.sessionAttribute("user");
		int planetId = ctx.pathParamAsClass("id", Integer.class).get();
		
		Planet p = pService.getPlanetById(u.getUsername(), planetId);
		
		ctx.json(p).status(200);
	}


	public void createPlanet(Context ctx) {
		
		Planet planetToBeCreated = ctx.bodyAsClass(Planet.class);
		User u = ctx.sessionAttribute("user");
		
		Planet createdPlanet = pService.createPlanet(u.getUsername(),planetToBeCreated);
		
		ctx.json(createdPlanet).status(201);
	}

	public void deletePlanet(Context ctx) {
		
		int planetId = ctx.pathParamAsClass("id", Integer.class).get();
		
		pService.deletePlanetById(planetId);
		ctx.json("Planet successfully deleted").status(202);
	}
 */