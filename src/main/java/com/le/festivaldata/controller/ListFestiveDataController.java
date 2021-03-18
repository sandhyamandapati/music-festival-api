package com.le.festivaldata.controller;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.le.festivaldata.service.ListFestiveDataRestService;

@RestController
@RequestMapping("/api")
public class ListFestiveDataController {

	@Autowired
	private ListFestiveDataRestService listFestiveDataRestService;

	@GetMapping("/listFestiveData")
	public String getList() throws IOException {
		return listFestiveDataRestService.getFormattedFestivalShowsList();

	}
		
	@GetMapping("/get-festiveData")
	public  ResponseEntity<SortedMap<String, TreeMap<String, TreeSet<String>>>> getsortedFestivalList() throws IOException {
		return ResponseEntity.ok().body(listFestiveDataRestService.getFestivals());
	}
	
}
