package net.superdog.pizzas;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.superdog.pizzas.block.ModBlocks;
import net.superdog.pizzas.item.ModItemGroup;
import net.superdog.pizzas.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Pizzas implements ModInitializer {
	public static final String MOD_ID = "pizzas";
	public static final Logger LOGGER = LoggerFactory.getLogger("pizzas");

	// No magic constants!
	private static final Identifier JUNGLE_TEMPLE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/jungle_temple");

	private static final Identifier PLAINS_VILLAGE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_plains_house");
	private static final Identifier TAIGA_VILLAGE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_taiga_house");
	private static final Identifier DESERT_VILLAGE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_desert_house");
	private static final Identifier SAVANNA_VILLAGE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_savanna_house");

	private static final Identifier SNOWY_VILLAGE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_snowy_house");




	@Override
	public void onInitialize() {

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && JUNGLE_TEMPLE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && PLAINS_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && DESERT_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && SNOWY_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && TAIGA_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && SAVANNA_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO_SEEDS));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && PLAINS_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && DESERT_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && SNOWY_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && TAIGA_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO));
				tableBuilder.pool(poolBuilder);
			}
			if (source.isBuiltin() && SAVANNA_VILLAGE_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.TOMATO));
				tableBuilder.pool(poolBuilder);
			}

		});

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}