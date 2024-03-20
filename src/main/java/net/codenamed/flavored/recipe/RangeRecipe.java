package net.codenamed.flavored.recipe;
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

import java.util.List;

public class RangeRecipe implements Recipe<SimpleInventory> {
    private  final ItemStack output;
    private  final List<Ingredient> recipeItems;

    public RangeRecipe(List<Ingredient> ings, ItemStack itemStack) {
        this.output = itemStack;
        this.recipeItems = ings;
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        int size = 7;


        for (int x = 0; x < inventory.size(); x++) {



            if (inventory.getStack(x).isEmpty()) {
                size--;
            }
        }


        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 5; j++) {
                if (j == i) continue;
                for (int k = 2; k <= 5; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 2; l <= 5; l++) {
                        if (l == i || l == j || l == k) continue;

                        boolean result = recipeItems.get(1).test(inventory.getStack(i))
                                && recipeItems.get(2).test(inventory.getStack(j))
                                && recipeItems.get(3).test(inventory.getStack(k))
                                && recipeItems.get(4).test(inventory.getStack(l))
                                && recipeItems.get(0).test(inventory.getStack(1));

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

    public  static  class Type implements RecipeType<RangeRecipe> {
        public  static  final Type INSTANCE = new Type();
        public  static  final String ID = "frying";
    }


    public  static  class Serializer implements RecipeSerializer<RangeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "frying";

        public static final Codec<RangeRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(RangeRecipe::getIngredients),
                RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter(r -> r.output)
        ).apply(in, RangeRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }
        @Override
        public Codec<RangeRecipe> codec() {
            return CODEC;
        }

        @Override
        public RangeRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new RangeRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, RangeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult(null));
        }
    }




}