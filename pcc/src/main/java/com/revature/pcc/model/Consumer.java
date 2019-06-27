package com.revature.pcc.model;

public class Consumer {

	private Basket marketBasket;

	public Consumer(Basket marketBasket) {
		this.marketBasket = marketBasket;
	}

	public int consumeAGood() {
		return this.marketBasket.removeAGood();
	}

	public int consumeGoods(int amount) {
		return this.marketBasket.removeGoods(amount);
	}

}