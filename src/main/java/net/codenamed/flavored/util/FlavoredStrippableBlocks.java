package net.codenamed.flavored.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.codenamed.flavored.block.FlavoredBlocks;

public class FlavoredStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(FlavoredBlocks.ANCIENT_LOG, FlavoredBlocks.STRIPPED_ANCIENT_LOG);
        StrippableBlockRegistry.register(FlavoredBlocks.ANCIENT_WOOD, FlavoredBlocks.STRIPPED_ANCIENT_WOOD);
    }
}