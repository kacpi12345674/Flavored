package net.codenamed.flavored.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;

public class FlavoredVillagerTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(FlavoredVillagers.CHEF, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(FlavoredItems.SWEET_BERRY_MUFFIN, 32),
                            new ItemStack(FlavoredBlocks.CHEESE, 2),
                            6, 12, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(FlavoredVillagers.CHEF, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(FlavoredItems.CARBONARA, 1),
                            new ItemStack(FlavoredItems.CAULIFLOWER_SOUP, 1),
                            2, 12, 0.075f));
                });
    }

}

