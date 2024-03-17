package net.superdog.flavored.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.superdog.flavored.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.ANCIENT_LOG, 5, 5);
        registry.add(ModBlocks.ANCIENT_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_ANCIENT_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_ANCIENT_WOOD, 5, 5);

        registry.add(ModBlocks.ANCIENT_PLANKS, 5, 20);
        registry.add(ModBlocks.ANCIENT_LEAVES, 30, 60);
        registry.add(ModBlocks.FLOWERING_ANCIENT_LEAVES, 30, 60);

    }
}