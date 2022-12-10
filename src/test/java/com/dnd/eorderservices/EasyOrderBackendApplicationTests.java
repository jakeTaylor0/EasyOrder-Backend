package com.dnd.eorderservices;

import org.junit.Before;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class EasyOrderBackendApplicationTests {
	
	@Mock
	EasyOrderBackendApplication eorderApplication;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		EasyOrderBackendApplication eorderApplication = new EasyOrderBackendApplication();
		RestTemplate template=eorderApplication.restTemplate();
		assertNotNull(template);
	}
}
