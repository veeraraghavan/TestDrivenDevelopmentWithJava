package com.demo.samples.tdd.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	@JsonProperty("CategoryName")
	String categoryName;
	@JsonProperty("Description")
	String description;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
