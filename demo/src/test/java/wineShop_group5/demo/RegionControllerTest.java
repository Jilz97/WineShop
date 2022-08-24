package wineShop_group5.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RegionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Region

	@Test
	void all() throws Exception {
		mockMvc.perform(get("/api/region/")
				.contentType("aplication/json"));
	}
	@Test
	void one() throws Exception{
		mockMvc.perform(get("/api/region/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name",is("Toro")));	
	}
	@Test
	void notFound() throws Exception{
		assertThrows(Exception.class, ()->{
			mockMvc.perform(get("/api/region/0")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().is5xxServerError());
		});
	}

	@Test 
	void puttest() throws Exception{
		
		
	}
	
	
}
