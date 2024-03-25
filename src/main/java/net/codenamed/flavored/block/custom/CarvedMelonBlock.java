package net.codenamed.flavored.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CarvedMelonBlock extends HorizontalFacingBlock {

    public static BooleanProperty MELONED = BooleanProperty.of("meloned");

    public CarvedMelonBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH).with(MELONED, false));
    }


    public boolean hasComparatorOutput(BlockState state) {
        return state.get(MELONED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).getItem() == Items.MELON_SLICE && !state.get(MELONED)) {
            player.getStackInHand(hand).decrement(1);
            world.setBlockState(pos, state.with(MELONED, true));
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);


            return ActionResult.SUCCESS;
        }
        else if (player.getStackInHand(hand).isEmpty() && state.get(MELONED)) {
            player.getInventory().insertStack(1, Items.MELON_SLICE.getDefaultStack());
            world.setBlockState(pos, state.with(MELONED, false));
            world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.2F, 1.5F);

            return ActionResult.SUCCESS;
        }

        return  ActionResult.FAIL;
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return  15;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, MELONED});
    }




}
