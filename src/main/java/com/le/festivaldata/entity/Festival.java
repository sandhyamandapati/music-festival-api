package com.le.festivaldata.entity;

import java.util.List;

public class Festival {

	private String name = "Unknown Festival";
	private List<Band> bands;

	public void setName(String name) {
		this.name = name;
	}

	public void setBands(List<Band> bands) {
		this.bands = bands;
	}

	public String getName() {
		return name;
	}

	public List<Band> getBands() {
		return bands;
	}

	@Override
	public String toString() {
		return "Festival [name=" + name + ", bands=" + bands + "]";
	}

}
