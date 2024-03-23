package net.codenamed.flavored.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.codenamed.flavored.block.entity.RangeBlockEntity;

public class RangeBlockEntityRenderer implements BlockEntityRenderer<RangeBlockEntity> {
    public  RangeBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    public  static  final float[] positionsX = {0.25f, 0.25f, 0.75f, 0.75f};
    public  static  final float[] positionsZ = {0.25f, 0.75f, 0.25f, 0.75f};

    @Override
    public void render(RangeBlockEntity entity, float tickDelta,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemStack result = entity.getRenderStack();

        if (!result.isEmpty()) {
            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();


            matrices.push();
            matrices.translate(0.5, 1.02f, 0.5);
            matrices.scale(0.55f, 0.5f, 0.55f);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(270));

            itemRenderer.renderItem(result, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()),
                    OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);



            matrices.pop();
        }
        else {

            for (int i = 0; i < 4; i++) {


                ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
                ItemStack stack = entity.getRenderStack(i + 2);
                matrices.push();
                matrices.translate(positionsX[i], 1.02f, positionsZ[i]);
                matrices.scale(0.55f, 0.5f, 0.55f);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(270));

                if (stack.isEmpty()) {
                    stack = Items.AIR.getDefaultStack();
                }

                itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()),
                        OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);


                matrices.pop();
            }
        }




    }


    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
