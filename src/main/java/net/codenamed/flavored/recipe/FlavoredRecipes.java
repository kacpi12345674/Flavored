package net.codenamed.flavored.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.codenamed.flavored.Flavored;

public class FlavoredRecipes {

    public  static  void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Flavored.MOD_ID, FermenterRecipe.Serializer.ID ),
                FermenterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Flavored.MOD_ID, FermenterRecipe.Type.ID),
               FermenterRecipe.Type.INSTANCE );

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Flavored.MOD_ID, OvenRecipe.Serializer.ID),
                OvenRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Flavored.MOD_ID, OvenRecipe.Type.ID),
                OvenRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Flavored.MOD_ID, RangeRecipe.Serializer.ID),
                RangeRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Flavored.MOD_ID, RangeRecipe.Type.ID),
                RangeRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Flavored.MOD_ID, BoilerRecipe.Serializer.ID),
                BoilerRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Flavored.MOD_ID, BoilerRecipe.Type.ID),
                BoilerRecipe.Type.INSTANCE);

    }
}
