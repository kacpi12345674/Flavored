package net.codenamed.flavored.registry;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlavoredFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(FlavoredBlocks.ANCIENT_LOG, 5, 5);
        registry.add(FlavoredBlocks.ANCIENT_WOOD, 5, 5);
        registry.add(FlavoredBlocks.STRIPPED_ANCIENT_LOG, 5, 5);
        registry.add(FlavoredBlocks.STRIPPED_ANCIENT_WOOD, 5, 5);

        registry.add(FlavoredBlocks.ANCIENT_PLANKS, 5, 20);
        registry.add(FlavoredBlocks.ANCIENT_LEAVES, 30, 60);
        registry.add(FlavoredBlocks.FLOWERING_ANCIENT_LEAVES, 30, 60);

    }
}