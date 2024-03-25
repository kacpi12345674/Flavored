package net.codenamed.flavored.registry;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.codenamed.flavored.Flavored;

public class FlavoredVillagers {

    public  static  final  RegistryKey<PointOfInterestType> CHEF_POI_KEY = poiKey("chefpoi");

    public  static  final PointOfInterestType CHEF_POI = registerPoi("chefpoi", FlavoredBlocks.OVEN);

    public  static  final VillagerProfession CHEF = registerProfession("chef", CHEF_POI_KEY);




    private  static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Flavored.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE));
    }
    private  static  PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Flavored.MOD_ID, name), 1, 1, block);
    }

    private  static RegistryKey<PointOfInterestType> poiKey(String name) {
        return  RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Flavored.MOD_ID, name));
    }

    public  static  void registerVillagers() {
        Flavored.LOGGER.info("Registering Villagers for " + Flavored.MOD_ID);
    }
}
