package com.revature;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

//import com.revature.controller.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import io.javalin.Javalin;

@SpringBootApplication
public class MainDriver {

	public static void main(String[] args) {
		System.out.println("Starting app");
		SpringApplication.run(MainDriver.class, args);
	}

}

//public static Logger logger = LoggerFactory.getLogger(MainDriver.class);

// public static void main(String[] args) {
// 	Javalin app = Javalin.create(confg ->{
// 		confg.plugins.enableDevLogging();
// 	});
// 	RequestMapping.setupEndpoints(app);
// 	app.start(7000);
// }