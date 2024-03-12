package net.superdog.flavored.recipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;
import net.superdog.flavored.block.entity.FermenterBlockEntity;
import org.lwjgl.system.macosx.LibSystem;

import java.util.List;

public class OvenRecipe implements Recipe<SimpleInventory> {
    private  final ItemStack output;
    private  final List<Ingredient> recipeItems;

    public OvenRecipe(List<Ingredient> ings, ItemStack itemStack) {
        this.output = itemStack;
        this.recipeItems = ings;
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }


        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (j == i) continue;  // Skip combinations with the same number
                for (int k = 1; k <= 4; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 1; l <= 4; l++) {
                        if (l == i || l == j || l == k) continue;
                        boolean result = false;

                        if (recipeItems.size() == 4) {
                            result = recipeItems.get(0).test(inventory.getStack(i))
                                    && recipeItems.get(1).test(inventory.getStack(j))
                                    && recipeItems.get(2).test(inventory.getStack(k))
                                    && recipeItems.get(3).test(inventory.getStack(l));
                        }
                        else if (recipeItems.size() == 3) {
                            result = recipeItems.get(0).test(inventory.getStack(i))
                                    && recipeItems.get(1).test(inventory.getStack(j))
                                    && recipeItems.get(2).test(inventory.getStack(k));
                        }
                        else if (recipeItems.size() == 2) {
                            result = recipeItems.get(0).test(inventory.getStack(i))
                                    && recipeItems.get(1).test(inventory.getStack(j));

                        }

                        if (result) {
                            return  true;
                        }
                    }
                }
            }
        }
        return  false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient>list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public  static  class Type implements RecipeType<OvenRecipe> {
        public  static  final Type INSTANCE = new Type();
        public  static  final String ID = "baking";
    }


    public  static  class Serializer implements RecipeSerializer<OvenRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "baking";

        public static final Codec<OvenRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(OvenRecipe::getIngredients),
                RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter(r -> r.output)
        ).apply(in, OvenRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }
        @Override
        public Codec<OvenRecipe> codec() {
            return CODEC;
        }

        @Override
        public OvenRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new OvenRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, OvenRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult(null));
        }
    }




}