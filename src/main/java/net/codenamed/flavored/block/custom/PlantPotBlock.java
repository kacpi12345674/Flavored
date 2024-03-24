package net.codenamed.flavored.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.codenamed.flavored.registry.FlavoredBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

import static net.minecraft.block.FarmlandBlock.MOISTURE;

public class PlantPotBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public PlantPotBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(3, 9, 3, 13, 12, 13),
            Block.createCuboidShape(0, 0, 0, 16, 9, 16),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {BlockPos up = pos.up();if (world.getBlockState(up).isOf(FlavoredBlocks.TOMATO_CROP) || world.getBlockState(up).isOf(FlavoredBlocks.GARLICS) || world.getBlockState(up).isOf(FlavoredBlocks.ROSEMARY_BUSH)) {world.setBlockState(pos, state.with(MOISTURE, 7), 2);} else {super.randomTick(state, world, pos, random);}}
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}