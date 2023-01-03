package com.revature.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import com.revature.models.User;
//import com.revature.models.UsernamePasswordAuthentication;
// import com.revature.utilities.ConnectionUtil;

public interface UserDao extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into teams values(default, :username, :password)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "update users set password = :password where username = :username", nativeQuery = true)
    int updateUser(@Param("username") String username, @Param("password") String password);

}

// public class UserDao {
    
// 	public static Logger logger = LoggerFactory.getLogger(UserDao.class);


//     /*
//      * getUserByUsername executed and works as expected?: PASS
//      */
//     public User getUserByUsername(String username){
//         logger.info("In getUserByUsername method");

//         try (Connection connection = ConnectionUtil.createConnection()) {
//             String sql = "select * from users where username = ?";
//             PreparedStatement ps = connection.prepareStatement(sql);
//             ps.setString(1, username);
//             ResultSet rs = ps.executeQuery();
//             rs.next();
//             User user = new User();
//             user.setId(rs.getInt(1));
//             user.setUsername(rs.getString(2));
//             user.setPassword(rs.getString(3));
//             return user;
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//             return new User();
//         }
//     }

//     /*
//      * createUser executed and works as expected?: PASS
//      */
//     public User createUser(UsernamePasswordAuthentication registerRequest){
//         logger.info("In createUser method");
//         /*
//          * We will be making use of a try-with-resources block. This is a convenience provided starting in Java 8
//          * that allows us to "close" resources we open without having to write the code to do so
//          * This is a necessary action for our connection object that we will be creating because
//          * our database can only handle so many open connections at a time.
//          */
//         /*
//          * 1. We need to write our sql query (make a string to represent the query)
//          * 2. We need to provide the relevant information to our query (add username and password)
//          * 3. We need to execute the query
//          * 4. We need to handle any sort of response we get
//          */
//         try(Connection connection = ConnectionUtil.createConnection()) {
//             //1. Craft the query
//             String sql = "insert into users values (default, ?, ?)";//? are placeholders for info we will provide
//             /*
//              * We need to provide the prepareStatement method with the sql to be executed, and because we
//              * are returning a User object in the overall method we need to get the generated id from
//              * the user that is created
//              */
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//prepareStatement method needs the sql provided
//             //2. Provide relevant information
//             /*
//              * Keep in mind, when working with JDBC and entering/retrieving info, indexing starts at 1, not at 0
//              */
//             ps.setString(1, registerRequest.getUsername()); //Set username first because of order in table
//             ps.setString(2, registerRequest.getPassword()); //Set password second
//             //3. Execute query
//             ps.execute(); //execute the statement
//             ResultSet rs = ps.getGeneratedKeys(); //get the generated id and save it in a result set
//             //4. Handle the results
//             User newUser = new User();
//             rs.next();//Anytime you need to get info from a result set you must call next() once
//             int newId = rs.getInt("id");
//             newUser.setId(newId);
//             newUser.setUsername(registerRequest.getUsername());
//             newUser.setPassword(registerRequest.getPassword());
//             return newUser;

//         } catch (SQLException e) {
//             System.out.println(e.getMessage()); //perhaps log this info in your projects?
//             return new User();
//         }
//     }

//     // public static void main(String[] args){
//     //     UserDao dao = new UserDao();
//     //     UsernamePasswordAuthentication newUser = new UsernamePasswordAuthentication();
//     //     newUser.setUsername("Jon Snow");
//     //     newUser.setPassword("Winter is Coming");
//     //     System.out.println(dao.createUser(newUser).getId());
//     //     System.out.println(dao.getUserByUsername("Jon Snow"));
//     // }
// }
