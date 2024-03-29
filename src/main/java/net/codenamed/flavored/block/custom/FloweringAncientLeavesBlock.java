package net.codenamed.flavored.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.codenamed.flavored.registry.FlavoredBlocks;

import java.util.OptionalInt;

public class FloweringAncientLeavesBlock extends PlantBlock implements Fertilizable, Waterloggable {

    public static final int MAX_DISTANCE = 7;
    public static final IntProperty DISTANCE;
    public static final BooleanProperty PERSISTENT;
    public static final BooleanProperty WATERLOGGED;
    private static final int field_31112 = 1;
    public FloweringAncientLeavesBlock(Settings settings) {
        super(settings);         this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(DISTANCE, 7)).with(PERSISTENT, false)).with(WATERLOGGED, false));

    }

    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(DISTANCE) == 7 && !(Boolean)state.get(PERSISTENT);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
            BlockPos blockPos = pos.down();
            return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
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

        if (this.shouldDecay(state)) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }

    protected boolean shouldDecay(BlockState state) {
        return !(Boolean)state.get(PERSISTENT) && (Integer)state.get(DISTANCE) == 7;
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        grow(world, random, pos, state);

        world.setBlockState(pos, updateDistanceFromLogs(state, world, pos), 3);
    }

    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return 1;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        int i = getDistanceFromLog(neighborState) + 1;
        if (i != 1 || (Integer)state.get(DISTANCE) != i) {
            world.scheduleBlockTick(pos, this, 1);
        }

        return state;
    }

    private static BlockState updateDistanceFromLogs(BlockState state, WorldAccess world, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            mutable.set(pos, direction);
            i = Math.min(i, getDistanceFromLog(world.getBlockState(mutable)) + 1);
            if (i == 1) {
                break;
            }
        }

        return (BlockState)state.with(DISTANCE, i);
    }

    private static int getDistanceFromLog(BlockState state) {
        return getOptionalDistanceFromLog(state).orElse(7);
    }

    public static OptionalInt getOptionalDistanceFromLog(BlockState state) {
        if (state.isIn(BlockTags.LOGS)) {
            return OptionalInt.of(0);
        } else {
            return state.contains(DISTANCE) ? OptionalInt.of((Integer)state.get(DISTANCE)) : OptionalInt.empty();
        }
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.hasRain(pos.up())) {
            if (random.nextInt(15) == 1) {
                BlockPos blockPos = pos.down();
                BlockState blockState = world.getBlockState(blockPos);
                if (!blockState.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, Direction.UP)) {
                    ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.DRIPPING_WATER);
                }
            }
        }
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DISTANCE, PERSISTENT, WATERLOGGED});
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockState blockState = (BlockState)((BlockState)this.getDefaultState().with(PERSISTENT, true)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return updateDistanceFromLogs(blockState, ctx.getWorld(), ctx.getBlockPos());
    }

    static {
        DISTANCE = Properties.DISTANCE_1_7;
        PERSISTENT = Properties.PERSISTENT;
        WATERLOGGED = Properties.WATERLOGGED;
    }
}
