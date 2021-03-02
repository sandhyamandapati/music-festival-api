package com.le.festivaldata.entity;

import java.util.List;

public class Festival {

	private String name;
	private List<Band> bands;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Band> getBands() {
		return bands;
	}
	public void setBands(List<Band> bands) {
		this.bands = bands;
	}
	@Override
	public String toString() {
		return "Festival [name=" + name + ", bands=" + bands + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bands == null) ? 0 : bands.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		if (bands == null) {
			if (other.bands != null)
				return false;
		} else if (!bands.equals(other.bands))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
