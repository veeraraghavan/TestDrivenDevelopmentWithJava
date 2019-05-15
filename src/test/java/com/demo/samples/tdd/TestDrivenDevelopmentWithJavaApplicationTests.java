package com.demo.samples.tdd;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.demo.samples.tdd.responses.Category;
import com.demo.samples.tdd.responses.Structure1Root;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = TestDrivenDevelopmentWithJavaApplication.class)
public class TestDrivenDevelopmentWithJavaApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	@MockBean
	private RestTemplate client;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Structure1Root category = new Structure1Root();
		Category cat = new Category();
		cat.setCategoryName("Test1");
		cat.setDescription("Test");
		category.setD(cat);

		Mockito.when(client.exchange(
				ArgumentMatchers.eq("https://services.odata.org/V2/Northwind/Northwind.svc/Products(1)?$format=json"),
				ArgumentMatchers.eq(HttpMethod.GET), ArgumentMatchers.eq(null),
				ArgumentMatchers.eq(Structure1Root.class)))
				.thenReturn(new ResponseEntity<Structure1Root>(category, HttpStatus.OK));
	}

	@Test
	public void testendpoint1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/endpoint1?token=1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Test1")));

	}

}
