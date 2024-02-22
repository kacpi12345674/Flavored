package net.superdog.flavored.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();

    public static final FoodComponent GARLIC = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400, 0), 0.2F).build();

    public static final FoodComponent PIZZA_SLICE = new FoodComponent.Builder().hunger(7).saturationModifier(0.8f).build();

    public static final FoodComponent PUMPKIN_SLICE = new FoodComponent.Builder().hunger(1).saturationModifier(0.4f).build();

    public static final FoodComponent CAULIFLOWER_CURD = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();

    public static final FoodComponent SWEET_BERRY_MUFFIN = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 500, 0), 0.2F).build();

    public static final FoodComponent GLOW_BERRY_MUFFIN = new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).build();



    public static final FoodComponent SPAGHETTI = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build();

    public static final FoodComponent CARBONARA = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build();


    public static final FoodComponent OIL = new FoodComponent.Builder().hunger(1).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 0), 1F).build();


}


