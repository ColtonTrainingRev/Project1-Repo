package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Planet;
import com.revature.repository.PlanetDao;

public class PlanetService {

	private PlanetDao dao;

	public PlanetService(){
		this.dao = new PlanetDao();
	}

	/*
	 * getAllPlanets executed and works as expected?: PASS
	 */
	public List<Planet> getAllPlanets() throws SQLException {
		return this.dao.getAllPlanets();
	}

	/*
	 * getPlanetByName executed and works as expected?: PASS
	 */
	public Planet getPlanetByName(String owner, String planetName) {
		return this.dao.getPlanetByName(owner, planetName);
	}

	/*
	 * getPlanetById executed and works as expected?: PASS
	 */
	public Planet getPlanetById(String username, int planetId) {
		return this.dao.getPlanetById(username, planetId);
	}

	/*
	 * createPlanet executed and works as expected?: PASS
	 */
	public Planet createPlanet(String username, Planet p) {
		return this.dao.createPlanet(username, p);
	}

	/*
	 * deletePlanetById executed and works as expected?: PASS
	 */
	public void deletePlanetById(int planetId) {
		this.dao.deletePlanetById(planetId);
	}

	// public static void main(String[] args) {
		// PlanetService ps = new PlanetService();
		// Planet newPlanet = new Planet();
		// newPlanet.setOwnerId(1);
		// newPlanet.setName("Pluto");
		// try {
		// 	System.out.println(ps.getAllPlanets());
		// 	ps.deletePlanetById(2);
		// 	//ps.createPlanet("Billy", newPlanet);
		// 	System.out.println(ps.getAllPlanets());
		// } catch (SQLException e) {
		// 	System.out.println(e.getMessage());
		// }
		//System.out.println(ps.getPlanetById("Billy", 2));
		//System.out.println(ps.getPlanetByName("Billy", "Pluto"));
	// }

}
