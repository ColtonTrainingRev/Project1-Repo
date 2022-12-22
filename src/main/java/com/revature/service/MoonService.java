package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

public class MoonService {

	private MoonDao dao;

	public MoonService(){
		this.dao = new MoonDao();
	}

	/*
	 * getAllMoons executed and works as expected?: PASS
	 */
	public List<Moon> getAllMoons() throws SQLException {
        MoonDao.logger.info("In getAllMoons method");
		return this.dao.getAllMoons();
	}

	/*
	 * getMoonByName executed and works as expected?: PASS
	 */
	public Moon getMoonByName(String username, String moonName) {
		return this.dao.getMoonByName(username, moonName);
	}

	/*
	 * getMoonById executed and works as expected?: PASS
	 */
	public Moon getMoonById(String username, int moonId) {
		return this.dao.getMoonById(username, moonId);
	}

	/*
	 * createMoon executed and works as expected?: PASS
	 */
	public Moon createMoon(String username, Moon m) {
		return this.dao.createMoon(username, m);
	}

	/*
	 * deleteMoonById executed and works as expected?: PASS
	 */
	public void deleteMoonById(int moonId) {
		this.dao.deleteMoonById(moonId);
	}

	/*
	 * getMoonsFromPlanet executed and works as expected?: PASS
	 */
	public List<Moon> getMoonsFromPlanet(int planetId) throws SQLException {
		return this.dao.getMoonsFromPlanet(planetId);
	}

	// public static void main(String[] args) {
		// MoonService ms = new MoonService();
		// Moon newMoon = new Moon();
		// newMoon.setMyPlanetId(5);
		// newMoon.setName("Moon");
		// try {
		// 	System.out.println(ms.getAllMoons());
		// 	ms.deleteMoonById(4);
		// 	System.out.println(ms.getAllMoons());
		// } catch (SQLException e) {
		// 	System.out.println(e.getMessage());
		// }
	 	// ms.createMoon("Billy", newMoon);
		// System.out.println(ms.getMoonById("Billy", 4));
	// }

}
