package es.codeurjc.mastercloudapps.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureStubRunner(ids={"mgarcias2020:toposervice:+:stubs:8080"},
	stubsMode = StubsMode.LOCAL)
class CDCTests {

	@Test
	void verify_topo_service() {
		RestTemplate restTemplate = new RestTemplate();

		LandscapeResponse landscapeResponse = restTemplate.getForObject("http://localhost:8080/api/topographicdetails/Madrid", LandscapeResponse.class);

		assertEquals("Madrid", landscapeResponse.getId());
		assertEquals("Flat", landscapeResponse.getLandscape());
	}
}
