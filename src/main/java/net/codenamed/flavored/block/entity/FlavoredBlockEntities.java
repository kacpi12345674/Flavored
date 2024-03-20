package net.codenamed.flavored.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.codenamed.flavored.Flavored;
import net.codenamed.flavored.block.FlavoredBlocks;

public class FlavoredBlockEntities {

    public  static  final BlockEntityType<FermenterBlockEntity> FERMENTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Flavored.MOD_ID, "fermenter_be"),
                    FabricBlockEntityTypeBuilder.create(FermenterBlockEntity::new, FlavoredBlocks.FERMENTER).build());

    public  static  final BlockEntityType<OvenBlockEntity> OVEN_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Flavored.MOD_ID, "oven_be"),
                    FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new, FlavoredBlocks.OVEN).build());

    public  static  final BlockEntityType<RangeBlockEntity> RANGE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Flavored.MOD_ID, "range_be"),
                    FabricBlockEntityTypeBuilder.create(RangeBlockEntity::new, FlavoredBlocks.RANGE).build());

    public  static  final BlockEntityType<BoilerBlockEntity> BOILER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Flavored.MOD_ID, "boiler_be"),
                    FabricBlockEntityTypeBuilder.create(BoilerBlockEntity::new, FlavoredBlocks.RANGE).build());



    public  static  void registerBlockEntites() {
        Flavored.LOGGER.info("Registering Block Entities for " + Flavored.MOD_ID);
    }



}
