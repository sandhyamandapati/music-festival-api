package com.le.festivaldata.controller;

import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.le.festivaldata.service.ListFestiveDataRestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ListFestiveDataController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MusicFestivalIntegrationSpec {
	@LocalServerPort
	private int port;

	@Autowired
	ListFestiveDataRestServiceImpl service;

	@Autowired
	private TestRestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testgetsortedFestivalList() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String expectedJson = getResourceContent("Festival_Test.json");

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/get-festiveData"),
				HttpMethod.GET, entity, String.class);

		JSONAssert.assertEquals(expectedJson, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	private String getResourceContent(String filename) throws IOException {
		return IOUtils.toString(
				Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)), "UTF-8");
	}
}
