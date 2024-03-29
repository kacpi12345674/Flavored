package net.codenamed.flavored.registry;
import net.codenamed.flavored.Flavored;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FlavoredTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Flavored.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CROPS =
                createTag("crops");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Flavored.MOD_ID, name));
        }
    }
}
