package net.superdog.flavored;

import net.fabricmc.api.ModInitializer;

import net.superdog.flavored.block.ModBlocks;
import net.superdog.flavored.item.ModItemGroup;
import net.superdog.flavored.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Flavored implements ModInitializer {
	public static final String MOD_ID = "flavored";
	public static final Logger LOGGER = LoggerFactory.getLogger("flavored");


	@Override
	public void onInitialize() {


		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}