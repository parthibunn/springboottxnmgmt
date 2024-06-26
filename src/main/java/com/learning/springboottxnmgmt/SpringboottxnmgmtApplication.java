package com.learning.springboottxnmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringboottxnmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottxnmgmtApplication.class, args);
	}

}
