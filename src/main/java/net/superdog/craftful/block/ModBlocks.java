package net.superdog.craftful.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import net.superdog.craftful.Craftful;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.craftful.block.custom.PizzaBlock;
import net.superdog.craftful.block.custom.RackBlock;
import net.superdog.craftful.block.custom.TomatoCropBlock;
import net.superdog.craftful.block.custom.planterBlock;

public class ModBlocks {

    public static final Block RACK = registerBlock("rack",
            new RackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD)), ItemGroups.FUNCTIONAL);

    public static final Block PIZZA = registerBlock("pizza",
            new PizzaBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5f, 0.5f)), ItemGroups.FOOD_AND_DRINK);

    public static final Block PLANTER = registerBlock("planter",
            new planterBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F, 3.0F).sounds(BlockSoundGroup.MUD_BRICKS).nonOpaque().requiresTool()), ItemGroups.FUNCTIONAL);

    public static final Block TOMATO_CROP = registerBlock("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)),
            ItemGroups.getSearchGroup());

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Craftful.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Craftful.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        Craftful.LOGGER.info("Registering ModBlocks for " + Craftful.MOD_ID);
    }
}
