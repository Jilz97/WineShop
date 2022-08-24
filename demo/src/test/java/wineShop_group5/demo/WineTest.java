package wineShop_group5.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WineTest {
	@Autowired
	private MockMvc mockMvc;
	
	//Test all Wines
	@Test
	void allWines() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/wine/all").contentType("application/json")).andExpect(status().isOk());
	}
	//Test get Wine by Id
	@Test
	void idOne() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/wine/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", Matchers.is(1)))
		.andExpect(jsonPath("$.name",Matchers.is("Tinto")));
	}
	
	//Test create
	
	//test update
	
	//Test delete
	
	

}
