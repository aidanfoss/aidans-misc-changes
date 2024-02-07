package quantumaidan.aidansmiscchanges;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quantumaidan.aidansmiscchanges.util.CustomTrades;

public class AidansMiscChanges implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("aidans-misc-changes");

	@Override
	public void onInitialize() {
		boolean customTradesToggle = true; //change this to call from config file if I ever figure that out.

		if (customTradesToggle){
			CustomTrades.registerCustomTrades();
		}

		LOGGER.info("Hello Fabric world!");
	}
}