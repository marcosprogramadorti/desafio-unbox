/*
 * Autor: Marcos
 */

package com.unbox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}





}
