package net.superdog.flavored.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.flavored.Flavored;
import net.superdog.flavored.block.ModBlocks;

public class ModBlockEntities {

    public  static  final BlockEntityType<FermenterBlockEntity> FERMENTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Flavored.MOD_ID, "fermenter_be"),
                    FabricBlockEntityTypeBuilder.create(FermenterBlockEntity::new, ModBlocks.FERMENTER).build());



    public  static  void registerBlockEntites() {
        Flavored.LOGGER.info("Registering Block Entities for " + Flavored.MOD_ID);
    }



}
