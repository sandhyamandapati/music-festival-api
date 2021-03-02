package com.le.festivaldata.service;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public interface ListFestiveDataRestService {
	
	 /**
	   * get the list of festivals returns a sorted format
	   *
	   * @return Formatted musical festival data in alphabetical order 
	   * 
	   */
	 public SortedMap<String, TreeMap<String, TreeSet<String>>> getFestivals();

}
