package net.superdog.craftful.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PillarBlock;
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
import net.superdog.craftful.block.custom.*;
import net.superdog.craftful.item.ModItemGroup;

public class ModBlocks {

    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool()), ModItemGroup.CRAFTFUL);

    public static final Block LIMESTONE_BRICKS = registerBlock("limestone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool()), ModItemGroup.CRAFTFUL);

    public static final Block LIMESTONE_PILLAR = registerBlock("limestone_pillar",
            new LimestonePillarBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool()), ModItemGroup.CRAFTFUL);


    public static final Block RACK = registerBlock("rack",
            new RackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.CRAFTFUL);

    public static final Block PLANTER = registerBlock("planter",
            new planterBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F, 3.0F).sounds(BlockSoundGroup.MUD_BRICKS).nonOpaque().requiresTool()), ModItemGroup.CRAFTFUL);

    public static final Block PIZZA = registerBlock("pizza",
            new PizzaBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5f, 0.5f)), ModItemGroup.CRAFTFUL);

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
