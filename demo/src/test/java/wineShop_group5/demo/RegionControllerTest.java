package wineShop_group5.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.services.RegionService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RegionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Mock
	RegionService regionService;
	
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
	@WithMockUser(username = "user", roles= {"USER"})
	void addRegionTest() throws Exception{
		Region region = new Region();
		region.setName("prova");
		region.setCountry("prova");
		region.setId(200);
		
		Mockito.when(regionService.saveRegion(region)).thenReturn(region);
				
		ResultActions response = mockMvc.perform(post("/api/region/create/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(region)));
		
		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("prova")));
	}
/*
	@Test
	@WithMockUser(username = "user", roles= {"USER"})
	void updateRegionTest() throws Exception{
		Region region = new Region();
		region.setName("prova");
		region.setId(100);
		Mockito.when(regionService.updateRegion(100,region)).thenReturn(region);
		
		
		
		ResultActions response=mockMvc.perform(put("/api/region/update/100")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(region)));
		
		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("prova")));
				
	}
*/
	@Test
	@WithMockUser(username = "admin", roles= {"ADMIN"})
	void deleteRegionTest() throws Exception{
		
	
		mockMvc.perform(delete("/api/region/delete/200").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
