package com.bca.spring.crud.learningspringwithpostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.bca.spring.crud.learningspringwithpostgresql.Controller"})
//@ComponentScan(basePackages = {"com.bca.spring.crud.learningspringwithpostgresql.Exception"})
//@ComponentScan(basePackages = {"com.bca.spring.crud.learningspringwithpostgresql.Model"})
//@ComponentScan(basePackages = {"com.bca.spring.crud.learningspringwithpostgresql.repository"})
public class LearningSpringWithPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringWithPostgresqlApplication.class, args);
	}

}
