package net.codenamed.flavored.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.codenamed.flavored.registry.FlavoredBlocks;
import net.codenamed.flavored.registry.FlavoredItems;

public class FigBlock extends PlantBlock implements Fertilizable {
    private static final float field_31260 = 0.003F;
    public static final int MAX_AGE = 2;
    public static final IntProperty AGE;
    private static final VoxelShape SMALL_SHAPE;
    private static final VoxelShape LARGE_SHAPE;

    public FigBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {BlockPos up = pos.up();BlockState blockState = world.getBlockState(up);
        return blockState.isOf(FlavoredBlocks.FLOWERING_ANCIENT_LEAVES);
    }



    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(FlavoredItems.FIG);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((Integer)state.get(AGE) == 0) {
            return SMALL_SHAPE;
        } else {
            return (Integer)state.get(AGE) < 3 ? LARGE_SHAPE : super.getOutlineShape(state, world, pos, context);
        }
    }

    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 2;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 2 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState blockState = (BlockState)state.with(AGE, i + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, Emitter.of(blockState));
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return (Integer)state.get(AGE) < 2;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.down()).isAir();
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(2, (Integer)state.get(AGE) + 1);
        world.setBlockState(pos, (BlockState)state.with(AGE, i), 2);
    }

    static {
        AGE = Properties.AGE_2;
        SMALL_SHAPE = Block.createCuboidShape(3.0, 10.0, 3.0, 13.0, 16.0, 13.0);
        LARGE_SHAPE = Block.createCuboidShape(1.0, 6.0, 1.0, 15.0, 16.0, 15.0);
    }
}