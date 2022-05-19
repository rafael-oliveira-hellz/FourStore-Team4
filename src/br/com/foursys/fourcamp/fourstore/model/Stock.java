package br.com.foursys.fourcamp.fourstore.model;

public class Stock {
	private Integer currentId;
	
	public Stock() {
		currentId = 100;
	}

	public Integer getCurrentId() {
		return ++currentId;
	}
	
	
}

