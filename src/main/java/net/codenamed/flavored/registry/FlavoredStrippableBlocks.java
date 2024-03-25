package net.codenamed.flavored.registry;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class FlavoredStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(FlavoredBlocks.ANCIENT_LOG, FlavoredBlocks.STRIPPED_ANCIENT_LOG);
        StrippableBlockRegistry.register(FlavoredBlocks.ANCIENT_WOOD, FlavoredBlocks.STRIPPED_ANCIENT_WOOD);
    }
}