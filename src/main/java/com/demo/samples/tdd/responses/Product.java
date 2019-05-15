package com.demo.samples.tdd.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("ProductName")
	String productName;
	@JsonProperty("UnitPrice")
	String unitPrice;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	

}
