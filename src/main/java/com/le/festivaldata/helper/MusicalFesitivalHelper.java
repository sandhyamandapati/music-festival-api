package com.le.festivaldata.helper;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import com.le.festivaldata.entity.Band;
import com.le.festivaldata.entity.Festival;

public class MusicalFesitivalHelper {
	
	 /**
	   * @param festival list return from API
	   * @return sorted Map containing all data in alphabetic order 
	   * 
	   */
	public static TreeMap<String, TreeMap<String, TreeSet<String>>> getSortedList(List<Festival> festivals) {
		TreeMap<String, TreeMap<String, TreeSet<String>>> result = new TreeMap<>();

		if (festivals != null) {

			for (Festival f : festivals) {
				List<Band> bands = f.getBands();
				String name = f.getName();
				for (Band band : bands) {
					String bandName = band.getName();
					String recordLabel = band.getRecordLabel();
					if(recordLabel==null) {
						recordLabel="";
					}
					if (result.containsKey(recordLabel)) {
						TreeMap<String, TreeSet<String>> bandMap = result.get(recordLabel);
						if (name != null) {
							if (bandMap.containsKey(bandName)) {
								bandMap.get(bandName).add(name);
							} else {
								TreeSet<String> nameSet = new TreeSet<>();

								nameSet.add(name);
								bandMap.put(bandName, nameSet);
							}
						}
					} else {

						TreeMap<String, TreeSet<String>> bandMap = new TreeMap<>();
						TreeSet<String> names =null;
						if (name != null) {
							names = new TreeSet<>();
							names.add(name);
						}
						bandMap.put(bandName, names);
						
						result.put(recordLabel, bandMap);
					}
				}
			}
		}
		return result;
	}
	

}


