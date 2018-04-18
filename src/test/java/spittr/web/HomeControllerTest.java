package spittr.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
public class HomeControllerTest {
	@Test
	public void testHomePage() {
		HomeController controller = new HomeController();
		assertEquals("home", controller.home());
	}
	@Test
	public void testHomePage2() throws Exception {
		HomeController hc = new HomeController();
		MockMvc mock = standaloneSetup(hc).build();
		mock.perform(get("/")).andExpect(view().name("home"));
	}
}
