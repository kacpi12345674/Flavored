package net.superdog.flavored.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.superdog.flavored.Flavored;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.flavored.block.ModBlocks;
import net.superdog.flavored.item.custom.*;

public class ModItems {

    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new TomatoSeedItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

    public static final Item GARLIC = registerItem("garlic",
            new AliasedBlockItem(ModBlocks.GARLICS, (new FabricItemSettings()).food(ModFoodComponents.GARLIC)));

    public static final Item CAULIFLOWER_CURD = registerItem("cauliflower_curd",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER_CURD)));

    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice",
            new Item(new FabricItemSettings().food(ModFoodComponents.PUMPKIN_SLICE)));

    public static final Item FIG = registerItem("fig",
            new AliasedBlockItem(ModBlocks.FIG, (new FabricItemSettings()).food(ModFoodComponents.FIG)));

    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings()));

    public static final Item ROSEMARY = registerItem("rosemary",
            new AliasedBlockItem(ModBlocks.ROSEMARY_BUSH, new FabricItemSettings()));

    public static final Item OIL = registerItem("oil",
            new HoneyBottleItem(new FabricItemSettings().food(ModFoodComponents.OIL)));
    public static final Item PASTA = registerItem("pasta",
            new Item(new FabricItemSettings()));

    public static final Item ROASTED_CAULIFLOWER_CURD = registerItem("roasted_cauliflower_curd",
            new Item(new FabricItemSettings().food(ModFoodComponents.ROASTED_CAULIFLOWER_CURD)));

    public static final Item PIZZA_SLICE = registerItem("pizza_slice",
            new Item(new FabricItemSettings().food(ModFoodComponents.PIZZA_SLICE)));

    public static final Item CAULIFLOWER_SOUP = registerItem("cauliflower_soup",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER_SOUP).maxCount(1)));

    public static final Item SPAGHETTI = registerItem("spaghetti",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SPAGHETTI).maxCount(1)));

    public static final Item SALAD = registerItem("salad",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.SALAD).maxCount(1)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_STEM, new FabricItemSettings()));

    public static final Item CARBONARA = registerItem("carbonara",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.CARBONARA).maxCount(1)));

    public static final Item SWEET_BERRY_MUFFIN = registerItem("sweet_berry_muffin",
            new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_BERRY_MUFFIN)));

    public static final Item GLOW_BERRY_MUFFIN = registerItem("glow_berry_muffin",
            new Item(new FabricItemSettings().food(ModFoodComponents.GLOW_BERRY_MUFFIN)));

    public static final Item GLOW_BERRY_COCKTAIL = registerItem("glow_berry_cocktail",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.GLOW_BERRY_COCKTAIL)));

    public static final Item SWEET_BERRY_COCKTAIL = registerItem("sweet_berry_cocktail",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.SWEET_BERRY_COCKTAIL)));

    public static final Item CHORUS_COCKTAIL = registerItem("chorus_cocktail",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.CHORUS_COCKTAIL)));

    public static final Item FIG_COCKTAIL = registerItem("fig_cocktail",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.FIG_COCKTAIL)));

    public static final Item HOT_COCOA = registerItem("hot_cocoa",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.HOT_COCOA)));

    public static final Item TEA = registerItem("tea",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.TEA)));

    public static final Item PUMPKIN_LATTE = registerItem("pumpkin_latte",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.PUMPKIN_LATTE)));

    public static final Item CIDER = registerItem("cider",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.CIDER)));

    public static final Item SPINACH = registerItem("spinach",
            new Item(new FabricItemSettings().food(ModFoodComponents.SPINACH)));

    public static final Item SPINACH_SEEDS = registerItem("spinach_seeds",
            new AliasedBlockItem(ModBlocks.SPINACHES, new FabricItemSettings()));








    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Flavored.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Flavored.LOGGER.info("Registering Mod Items for " + Flavored.MOD_ID);


    }
}
