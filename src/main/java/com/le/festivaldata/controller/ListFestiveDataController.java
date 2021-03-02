package com.le.festivaldata.controller;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.le.festivaldata.service.ListFestiveDataRestService;

@RestController
public class ListFestiveDataController {

	@Autowired
	private ListFestiveDataRestService listFestiveDataRestService;

	@GetMapping("/listFestiveData")
	public SortedMap<String, TreeMap<String, TreeSet<String>>> getList() {
		return listFestiveDataRestService.getFestivals();

	}
}
