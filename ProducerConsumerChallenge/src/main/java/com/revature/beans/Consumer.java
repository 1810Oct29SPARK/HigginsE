package com.revature.beans;

public class Consumer {

	
	public void removeItems(int items,Basket basket ) {
		
		basket.setCurrentItems(basket.getCurrentItems()-items);
		
	}

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
