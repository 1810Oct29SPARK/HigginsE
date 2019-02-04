package com.revature.pcc;

import org.apache.logging.log4j.*;

import com.revature.pcc.configuration.*;

public class App {

    public static void main(String[] args) {

		Logger logger = LogManager.getLogger("mainLogger");

		logger.info("\n\n==================== Welcome to Market Simulator ====================\r\n");

		MarketConfiguration mc = new MarketConfiguration("market.properties");
		mc.configure();
		mc.printConfiguration();

		Market marketSim = mc.buildMarket();
		marketSim.openMarket();

		logger.info("==================== End of Market Simulator ====================\r\n\r\n");

    }

}
