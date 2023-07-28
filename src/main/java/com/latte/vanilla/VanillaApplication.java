package com.latte.vanilla;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class VanillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VanillaApplication.class, args);
	}

	@Value("#{systemEnvironment['HOST']}")
	public String hostname;

	@Value("${jail.name}")
	public String jailName;

	@GetMapping("/host")
	public String host() {
		return jailName;
	}

	@GetMapping("/env")
	public Map<String, String> env() {
		return System.getenv();
	}


}
