package net.superdog.pizzas.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.superdog.pizzas.Pizzas;
import net.superdog.pizzas.block.ModBlocks;

public class ModItemGroup {
    public static ItemGroup PIZZAS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Pizzas.MOD_ID, "pizzas_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pizzas_group"))
                    .icon(() -> new ItemStack(ModItems.PIZZA_SLICE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModBlocks.PIZZA);
                        entries.add(ModItems.PIZZA_SLICE);




                    }).build());

    public static void registerItemGroups() {
        // Example of adding to existing Item Group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}