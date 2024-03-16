package net.superdog.flavored;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.superdog.flavored.block.ModBlocks;
import net.superdog.flavored.screen.FermenterScreen;
import net.superdog.flavored.screen.ModScreenHandlers;
import net.superdog.flavored.screen.OvenScreen;

public class FlavoredClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSEMARY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLICS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ATTACHED_CAULIFLOWER_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPINACHES, RenderLayer.getCutout());


        HandledScreens.register(ModScreenHandlers.FERMENTER_SCREEN_HANDLER, FermenterScreen::new);
        HandledScreens.register(ModScreenHandlers.OVEN_SCREEN_HANDLER, OvenScreen::new);



    }
    }
