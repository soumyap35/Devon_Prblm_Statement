package com.devon.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Spring Bootstrap
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
@SpringBootApplication
@EnableSwagger2
public class DevonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevonApplication.class, args);
	}

}
