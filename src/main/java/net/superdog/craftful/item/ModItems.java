package net.superdog.craftful.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.superdog.craftful.Craftful;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.craftful.block.ModBlocks;
import net.superdog.craftful.item.custom.ModFoodComponents;
import net.superdog.craftful.item.custom.TomatoSeedItem;

public class ModItems {

    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new TomatoSeedItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

    public static final Item CHEESE = registerItem("cheese",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHEESE)));

    public static final Item PIZZA_SLICE = registerItem("pizza_slice",
            new Item(new FabricItemSettings().food(ModFoodComponents.PIZZA_SLICE)));

    public static final Item SWEET_BERRY_PIE = registerItem("sweet_berry_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_BERRY_PIE)));

    public static final Item GLOW_BERRY_PIE = registerItem("glow_berry_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.GLOW_BERRY_PIE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Craftful.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.CRAFTFUL, PIZZA_SLICE);
        addToItemGroup(ModItemGroup.CRAFTFUL, TOMATO);
        addToItemGroup(ModItemGroup.CRAFTFUL, CHEESE);
        addToItemGroup(ModItemGroup.CRAFTFUL, SWEET_BERRY_PIE);
        addToItemGroup(ModItemGroup.CRAFTFUL, GLOW_BERRY_PIE);
        addToItemGroup(ModItemGroup.CRAFTFUL, TOMATO_SEEDS);

    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        Craftful.LOGGER.info("Registering Mod Items for " + Craftful.MOD_ID);

        addItemsToItemGroup();
    }
}
