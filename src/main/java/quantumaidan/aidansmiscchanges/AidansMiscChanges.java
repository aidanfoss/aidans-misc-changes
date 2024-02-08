package quantumaidan.aidansmiscchanges;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quantumaidan.aidansmiscchanges.util.CustomDrops;
import quantumaidan.aidansmiscchanges.util.CustomTrades;

public class AidansMiscChanges implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("aidans-misc-changes");

	@Override
	public void onInitialize() {
		//TODO change this to call from config file if I ever figure that out.
		boolean customTradesToggle = true;
		boolean customCraftsToggle = true;
		boolean customsDropsToggle = true;

		if (customTradesToggle){
			CustomTrades.registerCustomTrades();
		}
		if (customCraftsToggle){
			//not sure if this is even possible to toggle tbh
			//9 string for a cobweb
			//wool block in the center for a dispenser
		}
		if (customsDropsToggle){
			CustomDrops.addAll();
		}

		LOGGER.info("Hello Fabric world!");
	}
}