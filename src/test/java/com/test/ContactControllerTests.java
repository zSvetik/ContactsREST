package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Ignore
	@Test
	public void noParamShouldReturnNoContent() throws Exception {
		this.mockMvc.perform(get("/hello/contacts").param("nameFilter", "")).andDo(print())
				.andExpect(status().isNoContent());
	}

	@Test
	public void withParamShouldReturnOk() throws Exception {
		this.mockMvc.perform(get("/hello/contacts").param("nameFilter", ".*e.*")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void noParamAndPathShouldReturnOk() throws Exception {
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isNotFound());
	}
}
