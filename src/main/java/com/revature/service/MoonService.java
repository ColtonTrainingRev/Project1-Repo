package com.revature.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

// import java.sql.SQLException;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Moon;
import com.revature.repository.MoonDao;

@Service
public class MoonService {

	@Autowired
	private MoonDao moonDao;

	public Moon getMoonById(int id) {
		Optional<Moon> possibleMoon = this.moonDao.findById(id);
		if(possibleMoon.isPresent()) {
			return possibleMoon.get();
		} else {
			return new Moon();
		}
	}

	public Moon getMoonByName(String name){
		Optional<Moon> possibleMoon = this.moonDao.findByMoonName(name);
		if(possibleMoon.isPresent()){
			return possibleMoon.get();
		} else {
			return new Moon();
		}
	}

	public List<Moon> getAllMoons(){
		List<Moon> moons = this.moonDao.findAll();
		if(moons.size() != 0){
			return moons;
		} else{
			throw new EntityNotFoundException("No moons were found");
		}
	}

	public String createMoon(Moon moon){
		this.moonDao.createMoon(moon.getName(), moon.getId());
		return "Moon Created";
	}

	public String deleteMoon(int id){
		this.moonDao.deleteById(id);
		return "Deleted moon with id of " + id;
	}

	// public String updateMoon(String moonName, int id){
	// 	int result = this.moonDao.updateMoon(moonName, id);
	// 	if(result == 1){
	// 		return "Moon successfully updated";
	// 	} else{
	// 		throw new EntityNotFoundException("Moon not found");
	// 	}
	// }
}
// 	private MoonDao dao;

// 	public MoonService(){
// 		this.dao = new MoonDao();
// 	}

// 	/*
// 	 * getAllMoons executed and works as expected?: PASS
// 	 */
// 	public List<Moon> getAllMoons() throws SQLException {
//         MoonDao.logger.info("In getAllMoons method");
// 		return this.dao.getAllMoons();
// 	}

// 	/*
// 	 * getMoonByName executed and works as expected?: PASS
// 	 */
// 	public Moon getMoonByName(String username, String moonName) {
// 		return this.dao.getMoonByName(username, moonName);
// 	}

// 	/*
// 	 * getMoonById executed and works as expected?: PASS
// 	 */
// 	public Moon getMoonById(String username, int moonId) {
// 		return this.dao.getMoonById(username, moonId);
// 	}

// 	/*
// 	 * createMoon executed and works as expected?: PASS
// 	 */
// 	public Moon createMoon(String username, Moon m) {
// 		return this.dao.createMoon(username, m);
// 	}

// 	/*
// 	 * deleteMoonById executed and works as expected?: PASS
// 	 */
// 	public void deleteMoonById(int moonId) {
// 		this.dao.deleteMoonById(moonId);
// 	}

// 	/*
// 	 * getMoonsFromPlanet executed and works as expected?: PASS
// 	 */
// 	public List<Moon> getMoonsFromPlanet(int planetId) throws SQLException {
// 		return this.dao.getMoonsFromPlanet(planetId);
// 	}

// 	// public static void main(String[] args) {
// 		// MoonService ms = new MoonService();
// 		// Moon newMoon = new Moon();
// 		// newMoon.setMyPlanetId(5);
// 		// newMoon.setName("Moon");
// 		// try {
// 		// 	System.out.println(ms.getAllMoons());
// 		// 	ms.deleteMoonById(4);
// 		// 	System.out.println(ms.getAllMoons());
// 		// } catch (SQLException e) {
// 		// 	System.out.println(e.getMessage());
// 		// }
// 	 	// ms.createMoon("Billy", newMoon);
// 		// System.out.println(ms.getMoonById("Billy", 4));
// 	// }

// }
