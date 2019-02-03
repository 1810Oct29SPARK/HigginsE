package com.revature.pcc.model;

public class Producer {

	private final Basket marketBasket;

	public Producer(Basket marketBasket) {
		super();
		this.marketBasket = marketBasket;
	}

	public int produceAGood() {
		return this.marketBasket.addAGood();
	}

	public int produceGoods(int amount) {
		return this.marketBasket.addGoods(amount);
	}

}
