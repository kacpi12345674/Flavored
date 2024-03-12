package net.superdog.flavored.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.superdog.flavored.Flavored;
import net.superdog.flavored.block.custom.*;
import net.superdog.flavored.item.ModItems;

public class ModBlocks {

    public static final Block PIZZA = registerBlock("pizza",
            new PizzaBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f, 0.5f)));

    public static final Block GARLIC_BREAD = registerBlock("garlic_bread",
            new GarlicBreadBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f, 0.5f)));

    public static final Block PUDDING = registerBlock("pudding",
            new PuddingBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.4f, 0.4f)));

    public static final Block CHEESE = registerBlock("cheese",
            new CheeseBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f, 0.5f)));

    public static final Block CAULIFLOWER = registerBlock("cauliflower",
            new CauliflowerBlock(FabricBlockSettings.create().mapColor(MapColor.WHITE).instrument(Instrument.DIDGERIDOO).strength(1.0F).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PLANT_POT = registerBlock("plant_pot",
            new PlantPotBlock(FabricBlockSettings.copyOf(Blocks.DECORATED_POT).strength(1.5F, 3.0F).sounds(BlockSoundGroup.STONE).nonOpaque().requiresTool()));

    public static final Block FERMENTER = registerBlock("fermenter",
            new FermenterBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));

    public static final Block OVEN = registerBlock("oven",
            new OvenBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)));



    public static final Block CAULIFLOWER_STEM = registerBlock("cauliflower_stem",
            new StemBlock((GourdBlock)CAULIFLOWER, () -> {
                return ModItems.CAULIFLOWER_SEEDS;
            }, FabricBlockSettings.create().mapColor(MapColor.LICHEN_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block ATTACHED_CAULIFLOWER_STEM = registerBlock("attached_cauliflower_stem",
            new AttachedStemBlock((GourdBlock)CAULIFLOWER, () -> {
                return ModItems.CAULIFLOWER_SEEDS;
            }, FabricBlockSettings.create().mapColor(MapColor.LICHEN_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block CARVED_CAULIFLOWER = registerBlock("carved_cauliflower",
            new WearableCarvedCauliflowerBlock(FabricBlockSettings.create().mapColor(MapColor.WHITE).strength(1.0F).sounds(BlockSoundGroup.WOOD).allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CARVED_MELON = registerBlock("carved_melon",
            new WearableCarvedMelonBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).strength(1.0F).sounds(BlockSoundGroup.WOOD).allowsSpawning(Blocks::always).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GARLICS = registerBlock("garlics",
            new GarlicsBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)
                    .mapColor(MapColor.PALE_GREEN)
                    .noCollision().ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block TOMATO_CROP = registerBlock("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block ROSEMARY_BUSH = registerBlock("rosemary_bush",
            new RosemaryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Flavored.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Flavored.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        Flavored.LOGGER.info("Registering ModBlocks for " + Flavored.MOD_ID);
    }
}
