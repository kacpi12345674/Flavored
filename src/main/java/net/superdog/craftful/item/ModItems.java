package net.superdog.craftful.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.superdog.craftful.Craftful;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Craftful.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {


    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        Craftful.LOGGER.info("Registering Mod Items for " + Craftful.MOD_ID);

        addItemsToItemGroup();
    }
}
