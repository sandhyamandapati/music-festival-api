package com.le.festivaldata.entity;

public class Band {

	private String name = "Unkown Band Name";
	private String recordLabel = "Unkown RecordLabel";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}

	@Override
	public String toString() {
		return "Band [name=" + name + ", recordLabel=" + recordLabel + "]";
	}
}
