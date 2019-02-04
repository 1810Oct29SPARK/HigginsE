package com.revature.pcc.runnable;

import java.util.*;
import java.time.*;

import org.apache.logging.log4j.*;

import com.revature.pcc.model.*;

public class ConsumptionCycle implements Runnable {

	private Consumer consumer;
	private LocalDateTime closeTime;
	private Random rand;
	private Logger logger;

	private int minConsumeAmount;
	private int maxConsumeAmount;
	private int minConsumeInterval;
	private int maxConsumeInterval;

	private LocalDateTime nextConsumeTime;

	public ConsumptionCycle(
		int minConsumeAmount,
		int maxConsumeAmount,
		int minConsumeInterval,
		int maxConsumeInterval,
		Basket marketBasket,
		Random rand
	) {
		super();
		this.minConsumeAmount = minConsumeAmount;
		this.maxConsumeAmount = maxConsumeAmount;
		this.minConsumeInterval = minConsumeInterval;
		this.maxConsumeInterval = maxConsumeInterval;
		this.rand = rand;
		this.logger = LogManager.getLogger("mainLogger");
		this.consumer = new Consumer(marketBasket);
	}

	public void setCloseTime(LocalDateTime closeTime) {
		this.closeTime = closeTime;
	}

	private int getConsumeAmount() {
		return this.rand.nextInt(this.maxConsumeAmount - this.minConsumeAmount + 1) + this.minConsumeAmount;
	}

	private void setNextConsumeTime() {
		long interval = (long) (this.rand.nextInt(this.maxConsumeInterval - this.minConsumeInterval + 1) + this.minConsumeInterval);
		interval = interval / 1000;
		this.nextConsumeTime = LocalDateTime.now().plusSeconds(interval);
	}

	@Override
	public void run() {

		this.logger.info("A new consumer has joined the market.");
		this.setNextConsumeTime();

		while (LocalDateTime.now().compareTo(this.closeTime) < 0) {

			while (LocalDateTime.now().compareTo(this.nextConsumeTime) < 0) {
				// Wait
			}

			if (this.closeTime.compareTo(this.nextConsumeTime) < 0) {
				break;
			}

			int ca = this.getConsumeAmount();
			this.consumer.consumeGoods(ca);
			logger.info(ca + " goods have been consumed and removed from the basket.");
			this.setNextConsumeTime();

		}

		this.logger.info("A consumer has exited the market.");

	}

}
