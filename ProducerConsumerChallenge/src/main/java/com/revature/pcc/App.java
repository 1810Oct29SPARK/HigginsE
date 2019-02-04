package com.revature.pcc;

import org.apache.logging.log4j.*;

import com.revature.pcc.configuration.*;

public class App {

    public static void main(String[] args) {

		Logger logger = LogManager.getLogger("mainLogger");

		logger.info("\n==================== Welcome to Market Simulator ====================\n");

		MarketConfiguration mc = new MarketConfiguration("market.properties");
		mc.configure();
		mc.printConfiguration();

		Market marketSim = mc.buildMarket();
		marketSim.openMarket();

		logger.info("\n==================== End of Market Simulator ====================\n");

    }

}
