package com.capstone.order.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class SupportApplication {


	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SupportApplication.class, args);
		//emailService.sendEmail(emailService.createEmailBody(orderService.getHO()),"text/html");
	}

}
