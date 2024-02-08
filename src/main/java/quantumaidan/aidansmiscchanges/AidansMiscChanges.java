package quantumaidan.aidansmiscchanges;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quantumaidan.aidansmiscchanges.util.CustomDrops;
import quantumaidan.aidansmiscchanges.util.CustomTrades;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class AidansMiscChanges implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("aidans-misc-changes");
	public  Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS; // Here is the Map
	@Override
	public void onInitialize() {
		//TODO change this to call from config file if I ever figure that out.
		boolean customTradesToggle = true;
		boolean customsDropsToggle = true;
		if (customTradesToggle){
			CustomTrades.registerCustomTrades();
		}
		if (customsDropsToggle){
			CustomDrops.addAll();
		}


//		boolean customCraftsToggle = true; TODO make this work if possible. Might have to do some weird shit to make it work. might not be possible
//		if (customCraftsToggle){
//			//not sure if this is even possible to toggle tbh
//			//9 string for a cobweb
//			//wool block in the center for a dispenser
//		}

		TillableBlockRegistry.register(Blocks.PODZOL, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		TillableBlockRegistry.register(Blocks.MYCELIUM, HoeItem::canTillFarmland, HoeItem.createTillAction(Blocks.FARMLAND.getDefaultState()));
		//after a few hours of fucking around with this code, I found a discord question asked 04/29/2022 which basically wrote this for me.
		//TO BE FAIR I was really, really close lol. I likely spent 3 or 4 hours on th
	}
}