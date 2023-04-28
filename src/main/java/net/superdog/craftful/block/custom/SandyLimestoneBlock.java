package net.superdog.craftful.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SandyLimestoneBlock extends FallingBlock {
    private int color = 0;

    public SandyLimestoneBlock(Settings settings) {
        super(settings);
        this.color = color;
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return this.color;
    }
}