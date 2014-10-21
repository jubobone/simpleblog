package com.twpnn.demo.simpleblog.controller;

import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;
import org.junit.Test;

import junit.framework.TestCase;

public class GreetingControllerTest extends TestCase {

	@Test
	public void testTheMethodShowAllGreetingsShouldReturnAResult() {
		// GIVEN
		GreetingController fakeGreetingService = mock(GreetingController.class);
		GreetingController controller = new GreetingController(
				fakeGreetingService);
		Map<String, Object> model = new HashMap<String, Object>();
		// WHEN
		String result = controller.showAllGreetings(model);
		// THEN
		assertNotNull(result);
		assertEquals("greetings", result);
	}

}
