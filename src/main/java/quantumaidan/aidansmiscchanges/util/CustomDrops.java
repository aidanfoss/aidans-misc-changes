package quantumaidan.aidansmiscchanges.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class CustomDrops {
    private static final Identifier GUARDIAN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/guardian");
    public static void addSpongeToGuardian(){
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && GUARDIAN_LOOT_TABLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(Items.SPONGE)) //adds sponge
                        .conditionally(RandomChanceLootCondition.builder(0.01f))//1% chance of dropping a sponge on death
                        ;

                tableBuilder.pool(poolBuilder);
            }

        }));
    }
    public static void addAll(){
        addSpongeToGuardian();
    }
}
