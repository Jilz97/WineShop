package wineShop_group5.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import wineShop_group5.demo.model.Winery;
import wineShop_group5.demo.services.WineryService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class WineryControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	WineryService wineryService;

	// Get all
	@Test
	public void getAllWineryAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/winery/all").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	// get all by ID
	@Test
	public void getWinaryByIdAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/winery/{identity}", 17).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

	}

	// test post
	@Test
	void postWinaryAPI() throws Exception {
		ObjectMapper mapa = new ObjectMapper();
		mapa.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapa.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(new Winery());

		mvc.perform(post("/api/winery/create").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isCreated());
	}

	// Test Update
	@Test
	void updateWinaryTestApi() throws Exception {

		ObjectMapper mapa = new ObjectMapper();
		mapa.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapa.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(new Winery("GFT"));
		mvc.perform(put("/api/winery/put/{identity}", 17).contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().is2xxSuccessful());

	}

	// delete test

	@Test
	void deleteWinreyAPI() throws Exception {
		mvc.perform(delete("/api/winery/delete/{identity}", 512).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}

}
