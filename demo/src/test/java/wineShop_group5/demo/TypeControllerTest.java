package wineShop_group5.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.services.TypeServices;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class TypeControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	TypeServices typeService;
		
	//Get all
	@Test 
	public void getAllTypeAPI() throws Exception {
		mockMvc.perform(get("/api/type/all")
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
}
	//get all by ID
	@Test
	public void getTypeByIdAPI() throws Exception 
	{
	  mockMvc.perform( MockMvcRequestBuilders
	      .get("/api/type/{id}", 5)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	     
	}
	//test post
	 @Test
	 @WithMockUser(username = "user", roles= {"USER"})
	 void postTypeAPI() throws Exception {
	        ObjectMapper mapa = new ObjectMapper();
	        mapa.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapa.writer().withDefaultPrettyPrinter();
	        String requestJson = ow.writeValueAsString(new Type());


	        mockMvc.perform(post("/api/type/create")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(requestJson)
	                )
	                .andExpect(status().isOk());
	    }
	 //Test Update
	 @Test
	 @WithMockUser(username = "user", roles= {"USER"})
	  void updateTypeTestApi() throws Exception {
		 ObjectMapper mapa = new ObjectMapper();
	        mapa.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapa.writer().withDefaultPrettyPrinter();
	        String requestJson = ow.writeValueAsString(new Type(5, "GFT"));
	        mockMvc.perform(put("/api/type/update/{id}",5)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(requestJson)
	                )
	                .andExpect(status().isOk());
	 
	 }
	 @Test 
	 @WithMockUser(username = "admin", roles= {"ADMIN"})
	void deleteTypeAPI() throws Exception {
		 mockMvc.perform(delete("/api/type/delete/{id}",10)
                 .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk());
	}
}
