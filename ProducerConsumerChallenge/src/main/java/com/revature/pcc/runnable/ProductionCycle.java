package com.revature.pcc.runnable;

import java.util.*;
import java.time.*;

import org.apache.logging.log4j.*;

import com.revature.pcc.model.*;

public class ProductionCycle implements Runnable {

	private Producer producer;
	private LocalDateTime closeTime;
	private Random rand;
	private Logger logger;

	private int minProduceAmount;
	private int maxProduceAmount;
	private int minProduceInterval;
	private int maxProduceInterval;

	private LocalDateTime nextProduceTime;

	public ProductionCycle(
		int minProduceAmount,
		int maxProduceAmount,
		int minProduceInterval,
		int maxProduceInterval,
		Basket marketBasket,
		Random rand
	) {
		super();
		this.minProduceAmount = minProduceAmount;
		this.maxProduceAmount = maxProduceAmount;
		this.minProduceInterval = minProduceInterval;
		this.maxProduceInterval = maxProduceInterval;
		this.rand = rand;
		this.logger = LogManager.getLogger("mainLogger");
		this.producer = new Producer(marketBasket);
	}

	public void setCloseTime(LocalDateTime closeTime) {
		this.closeTime = closeTime;
	}

	private int getProduceAmount() {
		return this.rand.nextInt(this.maxProduceAmount - this.minProduceAmount + 1) + this.minProduceAmount;
	}

	private void setNextProduceTime() {
		long interval = (long) (this.rand.nextInt(this.maxProduceInterval - this.minProduceInterval + 1) + this.minProduceInterval);
		interval = interval / 1000;
		this.nextProduceTime = LocalDateTime.now().plusSeconds(interval);
	}

	@Override
	public void run() {

		this.logger.info("A new producer has joined the market.");
		this.setNextProduceTime();

		while (LocalDateTime.now().compareTo(this.closeTime) < 0) {

			while (LocalDateTime.now().compareTo(this.nextProduceTime) < 0) {
				// Wait
			}

			if (this.closeTime.compareTo(this.nextProduceTime) < 0) {
				break;
			}

			int pa = this.getProduceAmount();
			this.producer.produceGoods(pa);
			this.logger.info(pa + " goods have been produced and added to the basket.");
			this.setNextProduceTime();

		}

		this.logger.info("A producer has exited the market.");

	}

}
