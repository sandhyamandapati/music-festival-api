package com.le.festivaldata;


import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.le.festivaldata.entity.Band;
import com.le.festivaldata.entity.Festival;
import com.le.festivaldata.helper.MusicalFesitivalHelper;

@SpringBootTest
class FestivalDataApiApplicationTests {
	
	@Test
	void  test() {
		Festival festival = new Festival();
		festival.setName("Small Night In");
		List<Band> bands1 = new ArrayList<>();
		Band b1=new Band();
		b1.setName("Squint-281");
		b1.setRecordLabel("Outerscope");;
		bands1.add(b1);
		
		Band b2=new Band();
		b2.setName("Yanke East");
		b2.setRecordLabel("MEDIOCRE Music");;
		bands1.add(b2);
		festival.setBands(bands1 );
		List<Festival> festivals = new ArrayList<>();	
		festivals.add(festival);
		
		String  result = null;
		result = MusicalFesitivalHelper.getSortedList(festivals).toString();
		
		assertThat("sorted data",result.equals(expectedData()));
	}
	
	private static String  expectedData() {
		
		TreeMap<String, TreeMap<String, TreeSet<String>>> result = new TreeMap<>();
		TreeMap<String, TreeSet<String>> bandMap = new TreeMap<>();
		TreeSet<String> names =new TreeSet<String>();
		names.add("Small Night In");
		bandMap.put("Yanke East", names);
		result.put("MEDIOCRE Music", bandMap);
		
		TreeMap<String, TreeSet<String>> bandMap1 = new TreeMap<>();
		TreeSet<String> names1 =new TreeSet<String>();
		names1.add("Small Night In");
		bandMap1.put("Squint-281", names1);
		
		result.put("Outerscope", bandMap1);
		result.put("MEDIOCRE Music", bandMap);
		
		return result.toString();
		
	}
	
}
