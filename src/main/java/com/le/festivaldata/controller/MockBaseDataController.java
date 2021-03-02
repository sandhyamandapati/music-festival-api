package com.le.festivaldata.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.le.festivaldata.entity.Festival;

@RestController
public class MockBaseDataController {

	@GetMapping("festivals")
	public List<Festival> getFestival(){
		ObjectMapper objectMapper = new ObjectMapper();
		List<Festival> festivals=null;
		try {
			festivals = objectMapper.readValue(new File("src/main/resources/Festivals.json"), new TypeReference<List<Festival>>() {});
		} catch (IOException e) {
			e.printStackTrace();
			 String.format("Failed to parse json: %s", e.getMessage());
		}
		
		return festivals;
	}
}
