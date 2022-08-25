package wineShop_group5.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.services.TypeServices;

class TypeControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TypeServices typeService;
	
	@Test
	void allTypeTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/type/all").contentType("application/json"))
		.andExpect(status().isOk());
	}
	
	@Test
	void idOne() throws Exception {
		mockMvc.perform(get("/api/type/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name",is("Toro Red")));
	}
	
//	@Test
//	public void addTypeTest() throws Exception{
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
//		String requestJson = objectWriter.writeValueAsString(new Type());
//		
//		mockMvc.perform(post("/api/type/create").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isCreated());
//	}
//	
//	@Test
//	public void TypeUpdateTest() throws Exception{
//		Type type = new Type();
//		type.setName("Test");
//		mockMvc.perform(put("/api/type/update/{id}")).content(requestJson).contentType(MediaType.APPLICATION_JSON).andExpect(status().isOk());
//	}

	
	@Test
	void deleteTypeTest() throws Exception{
		Type type = new Type();
		type.setId(23);
		Mockito.when(typeService.postType(type)).thenReturn(type);
		
		mockMvc.perform(delete("/api/type/delete/23")).andExpect(status().isOk());
	}
	
	@Test
	public void noId() throws Exception{
		
	}
	
	@Test
	public void noUpdate() throws Exception{
		
	}
	
	@Test
	public void noCreate() throws Exception{
		
	}
	
	@Test
	public void noDelete() throws Exception{
		
	}
}
