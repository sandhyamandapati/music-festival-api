package com.le.festivaldata.service;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.le.festivaldata.entity.Festival;
import com.le.festivaldata.helper.MusicalFesitivalHelper;

@Service
public class ListFestiveDataRestServiceImpl implements ListFestiveDataRestService{

	@Override
	public  SortedMap<String, TreeMap<String, TreeSet<String>>> getFestivals() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Festival>> festivalResponse =
		        restTemplate.exchange("http://localhost:8080/festivals",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Festival>>() {
		            });
		List<Festival> festivalList = festivalResponse.getBody();
		
		return MusicalFesitivalHelper.getSortedList(festivalList);
		
	}
	
	 public String getFormattedFestivalShowsList() throws IOException{
		 
		 ResponseEntity<List<Festival>> festivalResponse;
		 RestTemplate restTemplate = new RestTemplate();
		    try {
			 festivalResponse =
			        restTemplate.exchange("http://localhost:8080/festivals",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Festival>>() {
			            });
		    }
		    catch(HttpStatusCodeException ex) {
		        return ex.getResponseBodyAsString();
		    }
			List<Festival> festivalList = festivalResponse.getBody();
		    String result = MusicalFesitivalHelper.getSortedMusicFestivalList(festivalList);
		    return result;
		  }
	
}
