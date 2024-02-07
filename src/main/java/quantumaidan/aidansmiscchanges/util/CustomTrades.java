package quantumaidan.aidansmiscchanges.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
//import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
//import net.minecraft.potion.PotionUtil;
import net.minecraft.village.TradeOffer;

import java.util.HashMap;
import java.util.Map;

//import static net.minecraft.enchantment.Enchantments.*;

public class CustomTrades {
//I indented some shit kinda weird here. Might reformat it later. I think it makes more sense like this. sorry if anyone else sees this and cant understand it!
//Illegal Items
    static ItemStack protElytra = new ItemStack(Items.ELYTRA, 1);
        public static void setProtElytra(ItemStack protElytra) {
            CustomTrades.protElytra = protElytra;
            Map<Enchantment, Integer> map = new HashMap<>();
            map.put(Enchantments.PROTECTION, 4);
            EnchantmentHelper.set(map, protElytra);
        }
    static ItemStack lootingAxe = new ItemStack(Items.DIAMOND_AXE, 1);
        public static void setLootingAxe(ItemStack lootingAxe) {
            CustomTrades.lootingAxe = lootingAxe;
            Map<Enchantment, Integer> map = new HashMap<>();
            map.put(Enchantments.LOOTING, 3);
            EnchantmentHelper.set(map, lootingAxe);
        }
    static ItemStack silkSword = new ItemStack(Items.DIAMOND_SWORD, 1);
        public static void setSilkSword(ItemStack silkSword) {
            CustomTrades.silkSword = silkSword;
            Map<Enchantment, Integer> map = new HashMap<>();
            map.put(Enchantments.SILK_TOUCH, 1);
            EnchantmentHelper.set(map, silkSword);
        }

//Limited Items
    static ItemStack sneakBook = new ItemStack(Items.ENCHANTED_BOOK, 1);
        public static void setSneakBook(ItemStack sneakBook) {
            CustomTrades.sneakBook = sneakBook;
            Map<Enchantment, Integer> map = new HashMap<>();
            map.put(Enchantments.SWIFT_SNEAK, 3);
            EnchantmentHelper.set(map, sneakBook);
        }

    static ItemStack smithTemplate = new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1);
    //static ItemStack arrowLevitation = new ItemStack(Items.TIPPED_ARROW, 16);
        /* cant figure out how to do this
        public static void setArrowLevitation(ItemStack arrowLevitation) {
            CustomTrades.arrowLevitation = arrowLevitation;
            Map<Enchantment, Integer> map = new HashMap<>();
            PotionUtil.setPotion(arrowLevitation, PotionUtil.getPotion(LEVITATION));
            EnchantmentHelper.set(map, arrowLevitation);
        }
        */

    public static void registerCustomTrades() {
        boolean illegalItems = true; //make sub setting to disable illegal items
        boolean limitedItems = true;

        if (illegalItems){
            setProtElytra(protElytra); //init protection elytra
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.NETHERITE_INGOT, random.nextBetweenExclusive(6,10)),
                                protElytra,
                                1,6,0.05f)));

                    });
            setLootingAxe(lootingAxe);
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.NETHERITE_INGOT, random.nextBetweenExclusive(2,5)),
                                lootingAxe,
                                1,6,0.05f)));

                    });
            setSilkSword(silkSword);
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.NETHERITE_INGOT, random.nextBetweenExclusive(1,3)),
                                silkSword,
                                1,6,0.05f)));

                });
            /*
            setArrowLevitation(arrowLevitation);
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, random.nextBetweenExclusive(32,64)),
                                arrowLevitation,
                                1,6,0.05f)));

                    });
             */
        }

        if (limitedItems){
            setSneakBook(sneakBook);
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, random.nextBetweenExclusive(30,50)),
                                sneakBook,
                                1,6,0.05f)));
                    });
            //smithing template
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, random.nextBetweenExclusive(30,50)),
                                smithTemplate,
                                1,6,0.05f)));
                    });
        }
        //TradeOfferHelper.registerWanderingTraderOffers( //level, factory);
    }
}
