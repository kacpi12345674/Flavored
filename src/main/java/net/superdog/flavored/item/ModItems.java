package net.superdog.flavored.item;

import net.superdog.flavored.Flavored;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Flavored.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Flavored.LOGGER.info("Registering Mod Items for " + Flavored.MOD_ID);


    }
}
