package com.le.festivaldata.controller;

import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.le.festivaldata.service.ListFestiveDataRestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ListFestiveDataController.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FestivalAPIIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ListFestiveDataRestServiceImpl service;

	@Test
	public void getsortedFestivalList() throws Exception {
		final String link = "/api/get-festiveData";
		String expectedJson = getResourceContent("Festival_Test.json");
					
		mockMvc.perform(MockMvcRequestBuilders.get(link))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(expectedJson));
	}

	private String getResourceContent(String filename) throws IOException {
		return IOUtils.toString(
				Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)), "UTF-8");
	}
}
