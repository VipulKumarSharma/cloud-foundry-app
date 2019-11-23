package io.exploretheweb.cloudfoundryapp;

import io.exploretheweb.cloudfoundryapp.config.ConfigurationSettings;
import io.exploretheweb.cloudfoundryapp.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCaching
@RestController
@SpringBootApplication
public class CloudFoundryAppApplication implements CommandLineRunner {

	@Autowired
	UserResource userResource;

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

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n***********************************************");
		System.out.println("******** Cloud Foundry App Initialized ********");
		System.out.println("***********************************************\n");
		System.out.println(userResource.getUsers()+"\n");
	}
}
