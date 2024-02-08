package quantumaidan.aidansmiscchanges.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
    static ItemStack godApple = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1);
    static ItemStack potShard1 = new ItemStack(Items.ANGLER_POTTERY_SHERD);
    static ItemStack potShard2 = new ItemStack(Items.ARCHER_POTTERY_SHERD);
    static ItemStack potShard3 = new ItemStack(Items.ARMS_UP_POTTERY_SHERD);
    static ItemStack potShard4 = new ItemStack(Items.BLADE_POTTERY_SHERD);
    static ItemStack potShard5 = new ItemStack(Items.BREWER_POTTERY_SHERD);
    static ItemStack potShard6 = new ItemStack(Items.BURN_POTTERY_SHERD);
    static ItemStack potShard7 = new ItemStack(Items.DANGER_POTTERY_SHERD);
    static ItemStack potShard8 = new ItemStack(Items.EXPLORER_POTTERY_SHERD);
    static ItemStack potShard9 = new ItemStack(Items.FRIEND_POTTERY_SHERD);
    static ItemStack potShard10 = new ItemStack(Items.HEART_POTTERY_SHERD);
    static ItemStack potShard11 = new ItemStack(Items.HEARTBREAK_POTTERY_SHERD);
    static ItemStack potShard12 = new ItemStack(Items.HOWL_POTTERY_SHERD);
    static ItemStack potShard13 = new ItemStack(Items.MINER_POTTERY_SHERD);
    static ItemStack potShard14 = new ItemStack(Items.MOURNER_POTTERY_SHERD);
    static ItemStack potShard15 = new ItemStack(Items.PLENTY_POTTERY_SHERD);
    static ItemStack potShard16 = new ItemStack(Items.PRIZE_POTTERY_SHERD);
    static ItemStack potShard17 = new ItemStack(Items.SHEAF_POTTERY_SHERD);
    static ItemStack potShard18 = new ItemStack(Items.SHELTER_POTTERY_SHERD);
    static ItemStack potShard19 = new ItemStack(Items.SKULL_POTTERY_SHERD);
    static ItemStack potShard20 = new ItemStack(Items.SNORT_POTTERY_SHERD);






    //static ItemStack arrowLevitation = new ItemStack(Items.TIPPED_ARROW, 16);
        /* cant figure out how to do this TODO make levitation arrows work
        public static void setArrowLevitation(ItemStack arrowLevitation) {
            CustomTrades.arrowLevitation = arrowLevitation;
            Map<Enchantment, Integer> map = new HashMap<>();
            PotionUtil.setPotion(arrowLevitation, PotionUtil.getPotion(LEVITATION));
            EnchantmentHelper.set(map, arrowLevitation);
        }
        */


//-------------------------------------------------------------------------------------------------------------------------------------
    public static void registerCustomTrades() {
//        boolean illegalItems = true; // TODO make sub setting to disable illegal items
        boolean toggleProtElytra = false;

        boolean limitedItems = true;
        boolean toggleWanderingSherds = true;

//        if (illegalItems){
            if (toggleProtElytra){ //todo make gamerule or setting here. tough to toggle off if toggled on ever tbh.
                setProtElytra(protElytra); //init protection elytra
                TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.NETHERITE_INGOT, random.nextBetweenExclusive(6,10)),
                                protElytra,
                                1,6,0.05f)));

                    }
                );
            }
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
//        }

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

            //God Apple
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.GOLD_BLOCK, random.nextBetweenExclusive(6,16)),
                                godApple,
                                1,6,0.05f)));
                    });

            //The Following are all Sherd Trades. TODO make each unique? also add gamerule?
            if (toggleWanderingSherds) {
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard1, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard2, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard3, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard4, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard5, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard6, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard7, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard8, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard9, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard10, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard11, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard12, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard13, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard14, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard15, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard16, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard17, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard18, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard19, 2, 6, 0.05f)));
                });
                TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(
                            Items.EMERALD, random.nextBetweenExclusive(24, 48)), potShard20, 2, 6, 0.05f)));
                });
            }
        }
        //TradeOfferHelper.registerWanderingTraderOffers( //level, factory);
    }
}
