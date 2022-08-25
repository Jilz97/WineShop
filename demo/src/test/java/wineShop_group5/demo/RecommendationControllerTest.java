package wineShop_group5.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RecommendationControllerTest {
	
	@Autowired
	private MockMvc mvc;

	
	//Test Best Wines
	@Test
	public void getAllBestWinesAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/recommend/best")
				.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk());
				
	}
	
	//Test Expensive Wines
	@Test
	public void getAllExpensiveWinesAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/recommend/expensive")
				.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	
	//Test Vintage Wines
	@Test
	public void getAllVintageWinesAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/recommend/vintage")
				.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk());
	
	}
}
