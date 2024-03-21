package net.codenamed.flavored.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.codenamed.flavored.Flavored;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.codenamed.flavored.block.FlavoredBlocks;
import net.codenamed.flavored.item.custom.*;

public class FlavoredItems {

    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new TomatoSeedItem(FlavoredBlocks.TOMATO_CROP, new FabricItemSettings()));

    public static final Item GARLIC = registerItem("garlic",
            new AliasedBlockItem(FlavoredBlocks.GARLICS, (new FabricItemSettings()).food(ModFoodComponents.GARLIC)));

    public static final Item CAULIFLOWER_CURD = registerItem("cauliflower_curd",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER_CURD)));

    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice",
            new Item(new FabricItemSettings().food(ModFoodComponents.PUMPKIN_SLICE)));

    public static final Item FIG = registerItem("fig",
            new AliasedBlockItem(FlavoredBlocks.FIG, (new FabricItemSettings()).food(ModFoodComponents.FIG)));

    public static final Item DATES = registerItem("dates",
            new AliasedBlockItem(FlavoredBlocks.FIG, (new FabricItemSettings()).food(ModFoodComponents.DATES)));

    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings()));

    public static final Item ROSEMARY = registerItem("rosemary",
            new AliasedBlockItem(FlavoredBlocks.ROSEMARY_BUSH, new FabricItemSettings()));

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
            new AliasedBlockItem(FlavoredBlocks.CAULIFLOWER_STEM, new FabricItemSettings()));

    public static final Item CARBONARA = registerItem("carbonara",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.CARBONARA).maxCount(1)));

    public static final Item MASHED_POTATOES = registerItem("mashed_potatoes",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.MASHED_POTATOES).maxCount(1)));

    public static final Item GRILLED_VEGETABLES = registerItem("grilled_vegetables",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.GRILLED_VEGETABLES).maxCount(1)));

    public static final Item ALFREDO = registerItem("alfredo",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.ALFREDO).maxCount(1)));

    public static final Item FRUIT_SALAD = registerItem("fruit_salad",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.FRUIT_SALAD).maxCount(1)));

    public static final Item OCEAN_STEW = registerItem("ocean_stew",
            new StewItem(new FabricItemSettings().food(ModFoodComponents.OCEAN_STEW).maxCount(1)));




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

    public static final Item MALT = registerItem("malt",
            new DrinkItem(new FabricItemSettings().food(ModFoodComponents.MALT)));

    public static final Item DELICACY_POTTERY_SHERD = registerItem("delicacy_pottery_sherd",
            new Item(new FabricItemSettings()));

    public static final Item REFRESH_POTTERY_SHERD = registerItem("refresh_pottery_sherd",
            new Item(new FabricItemSettings()));


    public static final Item SPINACH = registerItem("spinach",
            new Item(new FabricItemSettings().food(ModFoodComponents.SPINACH)));

    public static final Item SPINACH_SEEDS = registerItem("spinach_seeds",
            new AliasedBlockItem(FlavoredBlocks.SPINACHES, new FabricItemSettings()));












    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Flavored.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Flavored.LOGGER.info("Registering Mod Items for " + Flavored.MOD_ID);


    }
}
