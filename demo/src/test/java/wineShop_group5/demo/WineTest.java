package wineShop_group5.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.BDDMockito.*;
import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.model.*;
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

	@MockBean
	WineServices wineServices;

	@Autowired
	private ObjectMapper objectMapper;
	
	Type type = new Type(5, "Red");
	Winery winery = new Winery("Teso La Monja");
    Region region = new Region(1, "Toro", "España");
    Wine wine = new Wine(1,"Tinto", "2002", 4.3f, 45, 38, "2", "2", winery, type, region);

	@Test
	void allWinesTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/wine/all").contentType("application/json"))
				.andExpect(status().isOk());
	}

	// Test get Wine by Id
	@Test
	void idOne() throws Exception {
		wine.setId(11);
		given(wineServices.getWineId(11)).willReturn(wine);
		mockMvc.perform(get("/api/wine/11").contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id", is(11)));
				//.andExpect(jsonPath("$.name", is("Tinto")));
	}

	// Test create
	@Test
	@WithMockUser(username = "user", roles= {"USER"})
	public void addWineTest() throws Exception {
		wine.setId(7550);
		wine.setName("createTest");
		given(wineServices.createWine(wine)).willAnswer((invocation) -> invocation.getArgument(0));

		ResultActions response = mockMvc.perform(post("/api/wine/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(wine)));

		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("createTest")));

	}

	// test update
	@Test
	@WithMockUser(username = "user", roles= {"USER"})
	public void updateWineTest() throws Exception {
		wine.setName("prova2");
		wine.setId(5);
		// me devuelve el wine 5
		Mockito.when(wineServices.updateWine(5, wine)).thenReturn(wine);

		ResultActions response = mockMvc.perform(put("/api/wine/update/5").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(wine)));

		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("prova2")));
	}

	// Test delete
	@Test
	@WithMockUser(username = "admin", roles= {"ADMIN"})
	public void deleteWineTest() throws Exception {
		int id = 2;
		willDoNothing().given(wineServices).deleteWine(id);
		ResultActions response = mockMvc.perform(delete("/api/wine/delete/{id}", id));
		response.andExpect(status().isOk()).andDo(print());

	}

}
