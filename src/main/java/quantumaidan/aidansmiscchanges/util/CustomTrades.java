package quantumaidan.aidansmiscchanges.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

import java.util.Map;

public class CustomTrades {
    static ItemStack protElytra = new ItemStack(Items.ELYTRA, 1);
    public static void setProtElytra(ItemStack protElytra) {
        CustomTrades.protElytra = protElytra;
        Map<ProtectionEnchantment, 4> map = EchantmentHelper.set(protElytra);
    }

    public static void registerCustomTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.NETHERITE_INGOT, 2),
                            protElytra,
                            1,6,0.05f));

                });
        //TradeOfferHelper.registerWanderingTraderOffers( //level, factory);
    }
}
