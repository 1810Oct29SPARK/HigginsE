package com.revature.pcc.configuration;

import java.util.*;
import java.time.*;
import java.io.*;

import org.apache.logging.log4j.*;

import com.revature.pcc.model.*;
import com.revature.pcc.runnable.*;

public class MarketConfiguration {

	private Logger logger;
	private Properties marketProperties;
	private boolean readyToBuild;

	private int marketRunTime;
	private int basketSize;
	private int initialLoad;
	private int numberOfProducers;
	private int numberOfConsumers;
	private int minProduceAmount;
	private int maxProduceAmount;
	private int minConsumeAmount;
	private int maxConsumeAmount;
	private int minProduceInterval;
	private int maxProduceInterval;
	private int minConsumeInterval;
	private int maxConsumeInterval;

	public MarketConfiguration(String propertiesFileName) {

		this.logger = LogManager.getLogger("mainLogger");
		this.logger.info("Loading market configuration properties...");

		ClassLoader cl = this.getClass().getClassLoader();
		this.marketProperties = new Properties();
		this.readyToBuild = false;

		try (InputStream in = cl.getResourceAsStream(propertiesFileName)) {
			this.marketProperties.load(in);
		} catch (Exception e) {
			System.out.println("Failed to load properties, abort.");
			this.marketProperties = null;
			return;
		}

		this.logger = LogManager.getLogger("mainLogger");
		this.logger.info("Successfully loaded market configuration.");

	}

	public int getMarketRunTime() {
		return this.marketRunTime;
	}

	public int getBasketSize() {
		return this.basketSize;
	}

	public int getInitialLoad() {
		return this.initialLoad;
	}

	public int getNumberOfProducers() {
		return this.numberOfProducers;
	}

	public int getNumberOfConsumers() {
		return this.numberOfConsumers;
	}

	public int getMinProduceAmount() {
		return this.minProduceAmount;
	}

	public int getMaxProduceAmount() {
		return this.maxProduceAmount;
	}

	public int getMinConsumeAmount() {
		return this.minConsumeAmount;
	}

	public int getMaxConsumeAmount() {
		return this.maxConsumeAmount;
	}

	public int getMinProduceInterval() {
		return this.minProduceInterval;
	}

	public int getMaxProduceInterval() {
		return this.maxProduceInterval;
	}

	public int getMinConsumeInterval() {
		return this.minConsumeInterval;
	}

	public int getMaxConsumeInterval() {
		return this.maxConsumeInterval;
	}

	public void configure() {

		if (this.marketProperties == null) {
			System.out.println("No properties loaded, cannot proceed.");
			return;
		}

		System.out.println("Reading properties...");

		try {
			this.marketRunTime = Integer.parseInt(this.marketProperties.getProperty("marketRunTime"));
			this.basketSize = Integer.parseInt(this.marketProperties.getProperty("basketSize"));
			this.initialLoad = Integer.parseInt(this.marketProperties.getProperty("initialLoad"));
			this.numberOfProducers = Integer.parseInt(this.marketProperties.getProperty("numberOfProducers"));
			this.numberOfConsumers = Integer.parseInt(this.marketProperties.getProperty("numberOfConsumers"));
			this.minProduceAmount = Integer.parseInt(this.marketProperties.getProperty("minProduceAmount"));
			this.maxProduceAmount = Integer.parseInt(this.marketProperties.getProperty("maxProduceAmount"));
			this.minConsumeAmount = Integer.parseInt(this.marketProperties.getProperty("minConsumeAmount"));
			this.maxConsumeAmount = Integer.parseInt(this.marketProperties.getProperty("maxConsumeAmount"));
			this.minProduceInterval = Integer.parseInt(this.marketProperties.getProperty("minProduceInterval"));
			this.maxProduceInterval = Integer.parseInt(this.marketProperties.getProperty("maxProduceInterval"));
			this.minConsumeInterval = Integer.parseInt(this.marketProperties.getProperty("minConsumeInterval"));
			this.maxConsumeInterval = Integer.parseInt(this.marketProperties.getProperty("maxConsumeInterval"));
		} catch (Exception e) {
			System.out.println("Error encountered due to invalid properties file. Exception type is " + e.getClass() + ". Abort.");
			return;
		}

		if (
			this.marketRunTime < 1000 ||
			this.basketSize < 10 ||
			this.initialLoad < 1 ||
			this.numberOfProducers < 1 ||
			this.numberOfConsumers < 1 ||
			this.minProduceAmount < 1 ||
			this.maxProduceAmount < 1 ||
			this.minConsumeAmount < 1 ||
			this.maxConsumeAmount < 1 ||
			this.minProduceInterval < 100 ||
			this.maxProduceInterval < 100 ||
			this.minConsumeInterval < 100 ||
			this.maxConsumeInterval < 100 ||
			this.basketSize < this.initialLoad ||
			this.maxProduceAmount < this.minProduceAmount ||
			this.maxConsumeAmount < this.minConsumeAmount ||
			this.maxProduceInterval < this.minProduceInterval ||
			this.maxConsumeInterval < this.minConsumeInterval
		) {
			throw new IllegalStateException("Invalid property values. Abort.");
		}

		this.logger.info("Configuration complete.\r\n");
		this.readyToBuild = true;

	}

	public void printConfiguration() {

		if (this.readyToBuild) {
			System.out.println("===== Configuration Report =====");
			System.out.println("marketRunTime: " + this.marketRunTime);
			System.out.println("basketSize: " + this.basketSize);
			System.out.println("initialLoad: " + this.initialLoad);
			System.out.println("numberOfProducers: " + this.numberOfProducers);
			System.out.println("numberOfConsumers: " + this.numberOfConsumers);
			System.out.println("minProduceAmount: " + this.minProduceAmount);
			System.out.println("maxProduceAmount: " + this.maxProduceAmount);
			System.out.println("minConsumeAmount: " + this.minConsumeAmount);
			System.out.println("maxConsumeAmount: " + this.maxConsumeAmount);
			System.out.println("minProduceInterval: " + this.minProduceInterval);
			System.out.println("maxProduceInterval: " + this.maxProduceInterval);
			System.out.println("minConsumeInterval: " + this.minConsumeInterval);
			System.out.println("maxConsumeInterval: " + this.maxConsumeInterval);
			System.out.println("===== End of Configuration Report =====\n");
		} else {
			System.out.println("Not configured or invalid configuration, cannot proceed.");
		}

	}

	public Market buildMarket() {

		if (this.readyToBuild) {
			return new ConfiguredMarket(this);
		} else {
			System.out.println("Not configured or invalid configuration, cannot proceed.");
			return null;
		}

	}

}

class ConfiguredMarket implements Market {

	private Logger logger;
	private boolean isClosed;
	private LocalDateTime openTime;
	private LocalDateTime closeTime;
	private Random rand;

	private final int marketRunTime;
	private final Basket marketBasket;
	private final List<ProductionCycle> activeProducers;
	private final List<ConsumptionCycle> activeConsumers;

	ConfiguredMarket(MarketConfiguration mc) {

		super();
		this.isClosed = false;
		this.rand = new Random();

		this.marketRunTime = mc.getMarketRunTime();

		this.marketBasket = new Basket(mc.getBasketSize());
		this.marketBasket.addGoods(mc.getInitialLoad());

		this.activeProducers = new ArrayList<>(mc.getNumberOfProducers());
		this.activeConsumers = new ArrayList<>(mc.getNumberOfConsumers());

		for (int i = 0; i < mc.getNumberOfProducers(); ++i) {
			this.activeProducers.add(new ProductionCycle(
				mc.getMinProduceAmount(),
				mc.getMaxProduceAmount(),
				mc.getMinProduceInterval(),
				mc.getMaxProduceInterval(),
				this.marketBasket,
				this.rand
			));
		}

		for (int i = 0; i < mc.getNumberOfConsumers(); ++i) {
			this.activeConsumers.add(new ConsumptionCycle(
				mc.getMinConsumeAmount(),
				mc.getMaxConsumeAmount(),
				mc.getMinConsumeInterval(),
				mc.getMaxConsumeInterval(),
				this.marketBasket,
				this.rand
			));
		}

		this.logger = LogManager.getLogger("mainLogger");
		this.logger.info("New market built.");

	}

	@Override
	public void openMarket() {

		if (this.isClosed) {
			System.out.println("This market is already closed.");
			return;
		}

		this.openTime = LocalDateTime.now();
		this.closeTime = this.openTime.plusSeconds((long) this.marketRunTime / 1000);

		List<Thread> threadPool = new ArrayList<>();

		this.activeProducers.forEach(
			ap -> {
				ap.setCloseTime(this.closeTime);
				threadPool.add(new Thread(ap));
			}
		);

		this.activeConsumers.forEach(
			ac -> {
				ac.setCloseTime(this.closeTime);
				threadPool.add(new Thread(ac));
			}
		);

		this.logger.info("Opening market...\r\n");

		threadPool.forEach(
			th -> {
				th.start();
			}
		);

		this.logger.info("Market is opened and fully operational.");

		threadPool.forEach(
			th -> {
				try {
					th.join();
				} catch (Exception e) {
					System.out.println("Thread interrupted. Abort.");
					this.isClosed = true;
					return;
				}
			}
		);

		this.closeMarket();

	}

	@Override
	public void closeMarket() {

		if (this.isClosed) {
			System.out.println("This market is already closed.");
			return;
		}

		this.logger.info("Market closed.\r\n");
		this.isClosed = true;
		this.printReport();

	}

	@Override
	public void printReport() {

		if (this.isClosed) {
			this.logger.info("===== Market Report =====");
			this.logger.info("Open time: " + this.openTime.toString());
			this.logger.info("Close time: " + this.closeTime.toString());
			this.logger.info("Total producers: " + this.activeProducers.size());
			this.logger.info("Total consumers: " + this.activeConsumers.size());
			this.logger.info("Goods in basket: " + this.marketBasket.getGoodList().size());
			this.logger.info("===== End of Market Report =====\r\n");
		} else {
			System.out.println("This market has not opened yet.");
		}

	}

}
