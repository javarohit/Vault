package com.rohit.demoVault_Lts;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoVaultLtsApplication {

	@Value("${db_username}")
	String username;
	@Value("${db_password}")
	String password;
	
	@Value("${splunk}")
	File splunk_cert;
	
	@Value("${godaddy_ca.crt}")
	File godaddy_cert;

	public static void main(String[] args) {
		SpringApplication.run(DemoVaultLtsApplication.class, args);
	}

	@PostConstruct
	public void run() {
		System.out.println("============================");
		System.out.println(username);
		System.out.println(password);
		System.out.println(splunk_cert);
		System.out.println(godaddy_cert);
		System.out.println("============================");
	}
}
