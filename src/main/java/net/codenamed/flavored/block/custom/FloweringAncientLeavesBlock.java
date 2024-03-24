package net.codenamed.flavored.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.codenamed.flavored.registry.FlavoredBlocks;

public class FloweringAncientLeavesBlock extends PlantBlock implements Fertilizable {
    public FloweringAncientLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }


    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.down()).getBlock() == Blocks.AIR;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        int r = random.nextBetween(1, 5);
        return world.getBlockState(pos.down()).getBlock() == Blocks.AIR && r == 1;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (canGrow(world, random, pos, state)) {
            world.setBlockState(pos.down(), FlavoredBlocks.FIG.getDefaultState());
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        grow(world, random, pos, state);
        super.randomTick(state, world, pos, random);
    }
}
