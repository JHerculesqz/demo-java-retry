package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RetryApplication {
	// #region main

	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

	// #endregion
}
