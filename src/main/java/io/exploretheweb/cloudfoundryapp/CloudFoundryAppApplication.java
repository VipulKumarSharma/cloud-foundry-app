package io.exploretheweb.cloudfoundryapp;

import io.exploretheweb.cloudfoundryapp.config.ConfigurationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CloudFoundryAppApplication {

	@Autowired
	private ConfigurationSettings configurationSettings;

	public static void main(String[] args) {
		SpringApplication.run(CloudFoundryAppApplication.class, args);
	}

	@GetMapping(value = "")
	public String getGreeting() {
		return configurationSettings.getGreeting();
	}

	@GetMapping(value = "/test")
	public String getName() {
		return configurationSettings.getName();
	}

}
