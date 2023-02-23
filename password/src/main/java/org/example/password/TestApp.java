package org.example.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EntityScan(basePackages = { "org.example" })
@SpringBootApplication(scanBasePackages = { "org.example" })
//@EnableCaching
public class TestApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(TestApp.class, args);
    }

}
