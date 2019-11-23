package io.exploretheweb.cloudfoundryapp;

import io.exploretheweb.cloudfoundryapp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CloudFoundryAppApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testApplicationYml() {
		String body = this.restTemplate.getForObject("/test", String.class);
		assertThat(body).isEqualTo("Welcome to Cloud Foundry App");
	}

	@Test
	public void testApplicationProperties() {
		String body = this.restTemplate.getForObject("/test/name", String.class);
		assertThat(body).isEqualTo("Cloud Foundry App");
	}

	@Test
	public void testUsers() {
		User user = new User("Yale", "Dev Team", 12345);
		List<User> users = new ArrayList<>();
		users.add(user);
		users = this.restTemplate.postForObject("/users", users, List.class);

		List<LinkedHashMap<String, Object>> userz = this.restTemplate.getForObject("/users/name/Yale", List.class);
		System.out.println("userz : "+userz);
		assertThat(userz.get(0).get("name")).isEqualTo("Yale");
	}

}
