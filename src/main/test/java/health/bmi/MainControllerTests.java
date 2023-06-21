package health.bmi;

import health.bmi.controller.MainController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:webapp/WEB-INF/application-context.xml"})
@AutoConfigureMockMvc
class MainControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCalculateBMI_Underweight() throws Exception {
		// Mock the request and send test data
		MvcResult result = mockMvc.perform(get("/bmi")
						.param("yourName", "John")
						.param("yourWeight", "50")
						.param("yourHeight", "1.7"))
				.andExpect(status().isOk())
				.andReturn();

		// Verify the response
		String response = result.getResponse().getContentAsString();
		// Add assertions to check if the response contains the expected values for underweight range
	}

	@Test
	public void testCalculatedBMI_helthyWeight() throws Exception{
		MvcResult result = mockMvc.perform(get("/bmi")
				.param("name", "Aleks")
				.param("yourWeight", "58")
				.param("yourHeight", "1.58"))
				.andExpect(status().isOk())
				.andReturn();

		String response = result.getResponse().getContentAsString();
	}

	@Test
	public void testCalculateBMI_overWeight() throws Exception{
		MvcResult result = mockMvc.perform(get("/bmi")
				.param("name", "Baron")
				.param("yourWeight", "70")
				.param("yourHeight", "1.58"))
				.andExpect(status().isOk())
				.andReturn();

		String response = result.getResponse().getContentAsString();
	}

	@Test
	public void testCalculatedBMI_obersity() throws Exception{
		MvcResult result = mockMvc.perform(get("/bmi")
				.param("name", "Boni")
				.param("yourWeight", "109")
				.param("yourHeight", "1.86"))
				.andExpect(status().isOk())
				.andReturn();

		String response = result.getResponse().getContentAsString();
	}

	// More test methods to cover other scenarios, such as healthy weight, overweight, and obesity


}
