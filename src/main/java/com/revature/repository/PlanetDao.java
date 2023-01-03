package com.revature.repository;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Planet;
// import com.revature.models.User;
// import com.revature.utilities.ConnectionUtil;

public interface PlanetDao extends JpaRepository<Planet, Integer> {
	
	Optional<Planet> findByPlanetName(String name);

	@Transactional
	@Modifying
	@Query(value = "insert into planets values(default, :planetName, :ownerId", nativeQuery = true)
	void createPlanet(@Param("planetName") String planetName, @Param("ownerId") int ownerId);

	@Transactional
	@Modifying
	@Query(value = "update teams set name = :planetName where ownerid = :ownerId", nativeQuery = true)
	int updatePlanet(@Param("planetName") String planetName, @Param("ownerId") int ownerId);

}
	/*
	public void deletePlanetById(int planetId) {
	public Planet createPlanet(String username, Planet p) {
	public Planet getPlanetById(String username, int planetId) {
	public Planet getPlanetByName(String owner, String planetName) {
    public List<Planet> getAllPlanets() throws SQLException {
	 */
    
// 	public static Logger logger = LoggerFactory.getLogger(PlanetDao.class);
// 	/*
// 	 * added the throws clause to the method signature because the alternative is to return an empty arraylist,
// 	 * but the method could succeed with no planets returned, which is not an ideal solution.
// 	 * Instead, we will let the service layer and/or API handle the exception being thrown.
// 	 */

// 	 /*
// 	  * getAllPlanets executed and works as expected?: PASS
// 	  */
// 	  public List<Planet> getAllPlanets() throws SQLException {
// 		logger.info("In getAllPlanets method");
// 		try(Connection connection = ConnectionUtil.createConnection()) { 
// 			String sql = "select * from planets";
// 			Statement statement = connection.createStatement();
// 			ResultSet rs = statement.executeQuery(sql);
// 			List<Planet> planets = new ArrayList<>();
// 			while(rs.next()){ //The next method retuns a boolean, so we can use it as our loops conditional
// 				Planet planet = new Planet();
// 				planet.setId(rs.getInt(1));
// 				planet.setName(rs.getString(2));
// 				planet.setOwnerId(rs.getInt(3));
// 				planets.add(planet);
// 			}
// 			return planets;
// 		 } //catch(SQLException e) {
// 		// 	System.out.println(e.getMessage());
// 		// 	throw e; //returning empty arraylist could give the wrong idea of what happened in the code
// 		// }
// 		// return null;
// 	}

// 	/*
// 	 * getPlanetByName executed and works as expected?: PASS
// 	 */
// 	public Planet getPlanetByName(String owner, String planetName) {
// 		logger.info("In getPlanetByName method");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from planets where name = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setString(1, planetName);
// 			ResultSet rs = ps.executeQuery();
// 			rs.next();
// 			Planet planet = new Planet();
// 			planet.setId(rs.getInt(1));
// 			planet.setName(rs.getString(2));
// 			planet.setOwnerId(rs.getInt(3));
// 			return planet;
// 		} catch (Exception e) {
// 			System.out.println(e.getMessage());
// 			return new Planet();
// 		}
// 	}

// 	/*
// 	 * getPlanetById executed and works as expected?: PASS
// 	 */
// 	public Planet getPlanetById(String username, int planetId) {
// 		logger.info("In getPlanetById method");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from planets where id = ?";// + planetId;
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setInt(1, planetId);
// 			ResultSet rs = ps.executeQuery();
// 			rs.next();
// 			Planet planet = new Planet();
// 			planet.setId(rs.getInt(1));
// 			planet.setName(rs.getString(2));
// 			planet.setOwnerId(rs.getInt(3));
// 			return planet;
// 		} catch (Exception e) {
// 			System.out.println(e.getMessage());
// 			return new Planet();
// 		}
// 	}

// 	/*
// 	 * createPlanet executed and works as expected?: PASS
// 	 */
// 	public Planet createPlanet(String username, Planet p) {
// 		logger.info("In createPlanet method");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
//             // String usql = "select * from users where username = " + username;
// 			// PreparedStatement uPs = connection.prepareStatement(usql, Statement.RETURN_GENERATED_KEYS);
// 			// ResultSet uRs = uPs.executeQuery();
// 			// uRs.next();

// 			String sql = "insert into planets values (default, ?, ?)";
// 			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
// 			ps.setString(1, p.getName());
// 			ps.setInt(2, p.getOwnerId());
// 			ps.execute();
// 			ResultSet rs = ps.getGeneratedKeys();
// 			Planet newPlanet = new Planet();
// 			rs.next();
// 			int newId = rs.getInt("id");
// 			newPlanet.setId(newId);
// 			newPlanet.setName(p.getName());
// 			newPlanet.setOwnerId(p.getOwnerId());
// 			return newPlanet;
			
// 			//punRs.getString(1); this returns the user id
// 			//Planets contain id, planet name, ownerid
// 			//users contain id, username, password
// 		} catch (SQLException e) {
// 			System.out.println(e.getMessage());
// 			return new Planet();
// 		}
// 	}

// 	/*
// 	 * deletePlanetById executed and works as expected?: PASS
// 	 */
// 	public void deletePlanetById(int planetId) {
// 		logger.info("In deleteP{lanetById method");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "delete from planets where id = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setInt(1, planetId);
// 			int rowsAffected = ps.executeUpdate();
// 			System.out.println("Rows affected: " + rowsAffected);
// 		} catch (SQLException e) {
// 			System.out.println(e.getMessage()); //good spot to add some logging?
// 		}
// 	}

// 	public static void main(String[] args){
// 		PlanetDao planetDao = new PlanetDao();
// 		// planetDao.deletePlanetById(6);
// 		// try {
// 		// 	System.out.println(planetDao.getAllPlanets());
// 		// } catch (Exception e) {
// 		// 	System.out.println(e.getMessage());
// 		// }
// 		Planet planet = new Planet();
// 		planet.setName("Jupiter");
// 		planet.setOwnerId(1);
// 		System.out.println(planetDao.createPlanet("Billy", planet));
// 		System.out.println(planetDao.getPlanetByName("Billy", planet.getName()));
// 	}
// }

