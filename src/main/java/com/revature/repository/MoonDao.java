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

import com.revature.models.Moon;
// import com.revature.utilities.ConnectionUtil;

public interface MoonDao extends JpaRepository<Moon, Integer> {

	Optional<Moon> findByMoonName(String name);

	@Transactional
	@Modifying
	@Query(value = "insert into moons values(default, :moonName, :ownerId)", nativeQuery = true)
	void createMoon(@Param("moonName") String moonName, @Param("ownerId") int ownerId);

	@Modifying
	@Transactional
	@Query(value = "update moons set name = :moonName where id = moonId", nativeQuery = true)
	int updateMoon(@Param("moonName") String moonName, @Param("moonId") int moonId);

}
//     public List<Moon> getAllMoons() throws SQLException {
//     public Moon getMoonByName(String username, String moonName) {
//     public Moon getMoonById(String username, int moonId) {
// 	   public Moon createMoon(String username, Moon m) {
// 	   public void deleteMoonById(int moonId) {
// 	   public List<Moon> getMoonsFromPlanet(int planetId) throws SQLException {

//}

// public class MoonDao {

// 	public static Logger logger = LoggerFactory.getLogger(MoonDao.class);
    
// 	/*
// 	 * getAllMoons executed and works as expected?: PASS
// 	 */
//     public List<Moon> getAllMoons() throws SQLException {
// 		logger.info("In getAllMoons method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from moons";
// 			Statement statement = connection.createStatement();
// 			ResultSet rs = statement.executeQuery(sql);
// 			List<Moon> moons = new ArrayList<>();
// 			while(rs.next()){
// 				Moon moon = new Moon();
// 				moon.setId(rs.getInt(1));
// 				moon.setName(rs.getString(2));
// 				moon.setMyPlanetId(rs.getInt(3));
// 				moons.add(moon);
// 			}
// 			return moons;
// 		} //catch (Exception e) {
// 		// System.out.println(e.getMessage());
// 		// throw e;
// 		//}
// 	}

// 	/*
// 	 * getMoonByName executed and works as expected?: PASS
// 	 */
// 	public Moon getMoonByName(String username, String moonName) {
// 		logger.info("In getMoonByName method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from moons where name = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setString(1, moonName);
// 			ResultSet rs = ps.executeQuery();
// 			rs.next();
// 			Moon moon = new Moon();
// 			moon.setId(rs.getInt(1));
// 			moon.setName(rs.getString(2));
// 			moon.setMyPlanetId(rs.getInt(3));
// 			return moon;

// 		} catch (Exception e) {
// 			System.out.println(e.getMessage());
// 			return new Moon();
// 		}
// 	}

// 	/*
// 	 * getMoonById executed and works as expected?: PASS
// 	 */
// 	public Moon getMoonById(String username, int moonId) {
// 		logger.info("In getMoonById method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from moons where id = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setInt(1, moonId);
// 			ResultSet rs = ps.executeQuery();
// 			rs.next();
// 			Moon moon = new Moon();
// 			moon.setId(rs.getInt(1));
// 			moon.setName(rs.getString(2));
// 			moon.setMyPlanetId(rs.getInt(3));
// 			return moon;
// 		} catch (Exception e) {
// 			System.out.println(e.getMessage());
// 			return new Moon();
// 		}
// 	}

// 	/*
// 	 * createMoon executed and works as expected?: PASS
// 	 */
// 	public Moon createMoon(String username, Moon m) {
// 		logger.info("In createMoon method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "insert into moons values (default, ?, ?)";
// 			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
// 			ps.setString(1, m.getName());
// 			ps.setInt(2, m.getMyPlanetId());
// 			ps.execute();
// 			ResultSet rs = ps.getGeneratedKeys();
// 			Moon newMoon = new Moon();
// 			rs.next();
// 			int newId = rs.getInt("id");
// 			newMoon.setId(newId);
// 			newMoon.setName(m.getName());
// 			newMoon.setMyPlanetId(m.getMyPlanetId());
// 			return newMoon;
// 		} catch (SQLException e) {
// 			System.out.println(e.getMessage());
// 			return new Moon();
// 		}
// 	}

// 	/*
// 	 * deleteMoonById executed and works as expected?: PASS
// 	 */
// 	public void deleteMoonById(int moonId) {
// 		logger.info("In deleteMoonById method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "delete from moons where id = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setInt(1, moonId);
// 			int rowsAffected = ps.executeUpdate();
// 			System.out.println("Rows affected: " + rowsAffected);
// 		} catch (SQLException e) {
// 			System.out.println(e.getMessage());
// 		}
// 	}

// 	/*
// 	 * getMoonsFromPlanet executed and works as expected?: PASS
// 	 */
// 	public List<Moon> getMoonsFromPlanet(int planetId) throws SQLException {
// 		logger.info("In getMoonsFromPlanet method.");
// 		try (Connection connection = ConnectionUtil.createConnection()) {
// 			String sql = "select * from moons where myplanetid = ?";
// 			PreparedStatement ps = connection.prepareStatement(sql);
// 			ps.setInt(1, planetId);
// 			ResultSet rs = ps.executeQuery();
// 			List<Moon> moons = new ArrayList<>();
// 			while(rs.next()){
// 				Moon moon = new Moon();
// 				moon.setId(rs.getInt(1));
// 				moon.setName(rs.getString(2));
// 				moon.setMyPlanetId(rs.getInt(3));
// 				moons.add(moon);
// 			}
// 			return moons;
// 		} //catch (SQLException e) {
// 			// TODO: handle exception
// 			//System.out.println(e.getMessage());
// 			//throw e;
// 		//}
// 	}

// 	// public static void main(String[] args){
// 		// MoonDao moonDao = new MoonDao();
// 		// Moon moon = new Moon();
// 		// moon.setName("Synco Paralax");
// 		// moon.setMyPlanetId(1);
		
// 		//moonDao.deleteMoonById(2);
// 		// System.out.println(moonDao.createMoon("Billy", moon));
// 		// try {
// 		// 	//System.out.println(moonDao.getMoonsFromPlanet(1) );
// 		// 	System.out.println(moonDao.getAllMoons());
// 		// } catch (Exception e) {
// 		// 	System.out.println(e.getMessage());
// 		// }
// 		// System.out.println(moonDao.getMoonByName("Billy", moon.getName()));
// 		// System.out.println(moonDao.getMoonById("Billy", 2));
		
// 	// }
// }
