package net.superdog.craftful.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.superdog.craftful.Craftful;
import net.superdog.craftful.block.ModBlocks;

public class ModItemGroup {
    public static ItemGroup CRAFTFUL;

    public static void registerItemGroups() {
        CRAFTFUL = FabricItemGroup.builder(new Identifier(Craftful.MOD_ID, "craftful"))
                .displayName(Text.translatable("itemgroup.craftful"))
                .icon(() -> new ItemStack(ModBlocks.PIZZA)).build();
    }
}