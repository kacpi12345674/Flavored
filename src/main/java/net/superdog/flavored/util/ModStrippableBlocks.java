package net.superdog.flavored.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.superdog.flavored.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ANCIENT_LOG, ModBlocks.STRIPPED_ANCIENT_LOG);
        StrippableBlockRegistry.register(ModBlocks.ANCIENT_WOOD, ModBlocks.STRIPPED_ANCIENT_WOOD);
    }
}