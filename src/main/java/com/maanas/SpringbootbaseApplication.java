package com.maanas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"com.maanas"})
@EnableJpaRepositories(basePackages="com.maanas")
@EnableTransactionManagement
@Import({SwaggerConfig.class})
@EnableScheduling
@EnableAutoConfiguration
public class SpringbootbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbaseApplication.class, args);
	}
}
