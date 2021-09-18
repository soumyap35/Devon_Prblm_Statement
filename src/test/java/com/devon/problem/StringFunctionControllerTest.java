package com.devon.problem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.devon.problem.controller.StringFunctionController;
import com.devon.problem.rest.model.AnagramInput;
import com.devon.problem.service.IStringFunctionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StringFunctionController.class)
public class StringFunctionControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	IStringFunctionService strFunctionSvcMock;
	
	@Autowired
	ObjectMapper objMapper;
	
	@Test
	void getMinCharDeletion() throws Exception {
		AnagramInput inp = new AnagramInput();
		inp.setStr1("abcde");
		inp.setStr2("abe");
		String inpJSON = objMapper.writeValueAsString(inp);
		mockMvc.perform(
				post("/api/v1/strfunction/anagram")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inpJSON)
		).andExpect(status().isOk());
	}
	
	@Test
	void getError1() throws Exception {
		AnagramInput inp = new AnagramInput();
		inp.setStr1("ASD");
		inp.setStr2("");
		String inpJSON = objMapper.writeValueAsString(inp);
		mockMvc.perform(
				post("/api/v1/strfunction/anagram")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inpJSON)
		).andExpect(status().isBadRequest());
	}
	
	@Test
	void getError2() throws Exception {
		AnagramInput inp = new AnagramInput();
		inp.setStr1("largerthanninechars");
		inp.setStr2("NOTSMALL");
		String inpJSON = objMapper.writeValueAsString(inp);
		mockMvc.perform(
				post("/api/v1/strfunction/anagram")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inpJSON)
		).andExpect(status().isBadRequest());
	}
}
