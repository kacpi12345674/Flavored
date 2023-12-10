package net.superdog.pizzas.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.pizzas.Pizzas;
import net.superdog.pizzas.block.custom.PizzaBlock;
import net.superdog.pizzas.block.custom.TomatoCropBlock;

public class ModBlocks {

    public static final Block PIZZA = registerBlock("pizza",
            new PizzaBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f, 0.5f)));


    public static final Block TOMATO_CROP = registerBlock("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pizzas.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Pizzas.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        Pizzas.LOGGER.info("Registering ModBlocks for " + Pizzas.MOD_ID);
    }
}
