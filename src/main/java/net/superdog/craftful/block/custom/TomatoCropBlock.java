package net.superdog.craftful.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.superdog.craftful.block.ModBlocks;
import net.superdog.craftful.item.ModItems;


public class TomatoCropBlock extends SweetBerryBushBlock {
    public TomatoCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {BlockPos down = pos.down();BlockState blockState = world.getBlockState(down);return blockState.isOf(Blocks.FARMLAND) || blockState.isOf(ModBlocks.PLANTER);}

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {

    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.TOMATO);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        boolean isMature = age == 3;
        if (!isMature && player.getStackInHand(hand).isOf(this.getSeedsItem().asItem())) {
            return ActionResult.PASS;
        } else if (isMature) {
            int i = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(this.getSeedsItem(), i + (age == 3 ? 1 : 0)));
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }


    protected ItemConvertible getSeedsItem() {
        return ModItems.TOMATO;
    }
}