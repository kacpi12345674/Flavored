package net.codenamed.flavored.mixin;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.codenamed.flavored.block.FlavoredBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public abstract class PlantBlockMixin extends Block {
    public PlantBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void yourModId$allowPlantingOnPlanter(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        Block block = world.getBlockState(pos).getBlock();
        if (block == FlavoredBlocks.PLANT_POT) {
            info.setReturnValue(true);

        }
    }

    public void  BecomeGarlic(BlockState floor, World world, BlockPos pos) {
        Block block = world.getBlockState(pos).getBlock();
        if (block == Blocks.PODZOL && this == Blocks.ALLIUM) {

            world.setBlockState(pos, (BlockState) FlavoredBlocks.GARLICS.getDefaultState(), 11);

        }
    }
}