package com.revature.beans;

public class Basket {

	private int currentItems;
	private int maxItems;
	public int getCurrentItems() {
		return currentItems;
	}
	public void setCurrentItems(int currentItems) {
		this.currentItems = currentItems;
	}
	public int getMaxItems() {
		return maxItems;
	}
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}
	public Basket(int currentItems, int maxItems) {
		super();
		this.currentItems = currentItems;
		this.maxItems = maxItems;
	}
	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Basket [currentItems=" + currentItems + ", maxItems=" + maxItems + "]";
	}
	
	
	
	
}

