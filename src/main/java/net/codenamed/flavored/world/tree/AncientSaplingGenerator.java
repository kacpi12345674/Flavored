package net.codenamed.flavored.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.codenamed.flavored.registry.FlavoredConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class AncientSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return FlavoredConfiguredFeatures.ANCIENT_KEY;
    }
    }
