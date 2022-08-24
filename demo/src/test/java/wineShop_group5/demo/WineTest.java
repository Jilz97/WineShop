package wineShop_group5.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.BDDMockito.*;
import wineShop_group5.demo.controller.WineController;
import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.WineRepository;
import wineShop_group5.demo.services.WineServices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WineTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	WineServices wineServices;

	@Autowired
	private ObjectMapper objectMapper;


	
	
	// Test all Wines
	@Test
	void allWinesTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/wine/all").contentType("application/json"))
				.andExpect(status().isOk());
	}

	// Test get Wine by Id
	@Test
	void idOne() throws Exception {
		mockMvc.perform(get("/api/wine/1").contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.name", is("Tinto")));
	}

	// Test create
	@Test
	public void addWineTest() throws Exception {
		Wine wine = new Wine();
		wine.setName("adeu");

		given(wineServices.createWine(wine)).willAnswer((invocation) -> invocation.getArgument(0));

		ResultActions response = mockMvc.perform(post("/api/wine/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(wine)));

		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("adeu")));

	}

	// test update
	@Test
	public void updateWineTest() throws Exception {
		Wine wine = new Wine();
		wine.setName("prova");
		//me devuelve el wine 5
		Mockito.when(wineServices.updateWine(5, wine)).thenReturn(wine);

		ResultActions response = mockMvc.perform(put("/api/wine/update/5").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(wine)));

		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("prova")));
	}
	// Test delete
	@Test
	public void deleteWineTest() throws Exception {
//		Wine wine = new Wine();
//		mockMvc.perform(delete("/api/wine/delete/10")).andExpect(status().isOk());
	}

}
