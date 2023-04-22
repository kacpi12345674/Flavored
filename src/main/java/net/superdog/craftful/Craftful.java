package net.superdog.craftful;

import net.fabricmc.api.ModInitializer;

import net.superdog.craftful.block.ModBlocks;
import net.superdog.craftful.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Craftful implements ModInitializer {
	public static final String MOD_ID = "craftful";
	public static final Logger LOGGER = LoggerFactory.getLogger("craftful");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}