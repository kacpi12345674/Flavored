package net.superdog.flavored.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.superdog.flavored.Flavored;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.flavored.block.ModBlocks;
import net.superdog.flavored.item.custom.ModFoodComponents;
import net.superdog.flavored.item.custom.TomatoSeedItem;

public class ModItems {

    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new TomatoSeedItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

    public static final Item PASTA = registerItem("pasta",
            new Item(new FabricItemSettings()));

    public static final Item PIZZA_SLICE = registerItem("pizza_slice",
            new Item(new FabricItemSettings().food(ModFoodComponents.PIZZA_SLICE)));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Flavored.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Flavored.LOGGER.info("Registering Mod Items for " + Flavored.MOD_ID);


    }
}
