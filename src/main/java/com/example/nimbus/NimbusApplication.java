package com.example.nimbus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Student API",
                version = "1.0.0",
                description = "This api is for CRUD operations of students",
                contact = @Contact(
                        name = "Sachintha Dilshan",
                        email = "sachinthadilshan96@gmail.com"
                )
        )
)
public class NimbusApplication {

    public static void main(String[] args) {

        SpringApplication.run(NimbusApplication.class, args);
    }

}
