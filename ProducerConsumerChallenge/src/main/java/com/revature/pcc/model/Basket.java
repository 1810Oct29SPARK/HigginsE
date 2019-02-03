package com.revature.pcc.model;

import java.util.*;

public class Basket {

	private final int size;
	private final List<Good> goodList;

	public Basket() {
		super();
		this.size = 100;
		this.goodList = new ArrayList<>(this.size);
	}

	public Basket(int size) {
		super();
		this.size = size;
		this.goodList = new ArrayList<>(this.size);
	}

	public List<Good> getGoodList() {
		return this.goodList;
	}

	public boolean isFull() {
		return this.goodList.size() >= this.size;
	}

	public synchronized int addAGood() {
		if (!this.isFull()) {
			this.goodList.add(new Good());
			return this.goodList.size();
		}
		return -1;
	}

	public synchronized int removeAGood() {
		if (!this.goodList.isEmpty()) {
			this.goodList.remove(this.goodList.size() - 1);
			return this.goodList.size();
		}
		return -1;
	}

	public synchronized int addGoods(int amount) {
		int count = 0;
		for (int i = 0; i < amount; ++i) {
			if (!this.isFull()) {
				this.goodList.add(new Good());
				++count;
			} else {
				break;
			}
		}
		return count;
	}

	public synchronized int removeGoods(int amount) {
		int count = 0;
		for (int i = 0; i < amount; ++i) {
			if (!this.goodList.isEmpty()) {
				this.goodList.remove(this.goodList.size() - 1);
				++count;
			} else {
				break;
			}
		}
		return count;
	}

}
