package binblee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthserverApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class AuthserverApplicationTests {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void homePageProtected(){
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/uaa/", String.class
		);
		assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		System.out.println("auth:" + auth);
		assertTrue("Wrong header: " + auth, auth.startsWith("Bearer realm=\""));
	}

	@Test
	public void userEndpointProtected() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:"
				+ port + "/uaa/user", String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		assertTrue("Wrong header: " + auth, auth.startsWith("Bearer realm=\""));
	}

	@Test
	public void authorizationRedirects() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:"
				+ port + "/uaa/oauth/authorize", String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		assertTrue("Wrong header: " + auth, auth.startsWith("Bearer realm=\""));
	}


}
