package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
	info = @Info(
			title = "Accounts Microservice Rest APIs",
			description = "Accounts Microservice Rest APIs for EazyBank",
			version = "v1.0",
			contact = @Contact(
					name = "Madhav Deshmukh",
					email = "madhavdeshmukh.com",
					url = "https://www.eazybytes.com"
			),
			license = @License(
				name = "Apache 2.0",
				url = "https://www.eazybytes.com"
			)
	),
	externalDocs = @ExternalDocumentation(
			description = "EazyBank Documentation",
			url = "https://www.eazybytes.com"
	)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
		System.out.println("Accounts app is running...");
	}

}
