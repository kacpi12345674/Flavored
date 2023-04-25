package net.superdog.craftful;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.superdog.craftful.block.ModBlocks;
import net.superdog.craftful.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Craftful implements ModInitializer {
	public static final String MOD_ID = "craftful";
	public static final Logger LOGGER = LoggerFactory.getLogger("craftful");

	// No magic constants!
	private static final Identifier JUNGLE_TEMPLE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/jungle_temple");

	@Override
	public void onInitialize() {

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && JUNGLE_TEMPLE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
		});

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}