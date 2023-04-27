package net.superdog.craftful.item.custom;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

        public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();

        public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build();

        public static final FoodComponent PIZZA_SLICE = new FoodComponent.Builder().hunger(7).saturationModifier(1f).build();

        public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(0.3F).build();
}



