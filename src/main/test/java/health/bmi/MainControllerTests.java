package health.bmi;

import health.bmi.repository.NewBmiDataRepository;
import org.junit.Test;
import health.bmi.controller.MainController;
//import health.bmi.repository.BmiDataRepository;
import health.bmi.service.BmiSendingService;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:webapp/WEB-INF/application-context.xml"})
@AutoConfigureMockMvc
public class MainControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private NewBmiDataRepository newBmiDataRepository;

	@Mock
	private BmiSendingService bmiSendingService;

	@InjectMocks
	private MainController mainController;


	public MainControllerTests() {
	}

//		public MainControllerTests (MainController mainController, BmiSendingService bmiSendingService,
//								BmiDataRepository bmiDataRepository) {
//		this.mainController = mainController;
//		this.bmiSendingService = bmiSendingService;
//		this.bmiDataRepository = bmiDataRepository;
//	}


	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void setBmiSendingService(BmiSendingService bmiSendingService) {
		this.bmiSendingService = bmiSendingService;
	}

	public void setNewBmiDataRepository(NewBmiDataRepository newBmiDataRepository) {
		this.newBmiDataRepository = newBmiDataRepository;
	}

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


	@Test
	public void testSendMail() {
		// Define the input parameters for the test
		double weight = 70.0;
		double height = 1.75;
		String name = "John Doe";
		String mail = "dinatale1980@mail.ru";

		// Call the controller method
		mainController.sendMail(weight, height, name, mail);

		// Verify that the sendingMessage method of BmiSendingService is called with the correct parameters
		verify(bmiSendingService).sendingMessage(eq(mail), anyDouble(), eq(name), eq(weight), eq(height));
	}

	@Test
	public void testGetBmi() {
		String name = "Alex Doe";

		mainController.getBmi(name);

		verify(bmiSendingService).getBmiByName(eq(name));
	}
}
