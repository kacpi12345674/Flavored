package net.superdog.flavored.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superdog.flavored.Flavored;

public class ModRecipes {

    public  static  void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Flavored.MOD_ID, FermenterRecipe.Serializer.ID ),
                FermenterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Flavored.MOD_ID, FermenterRecipe.Type.ID),
               FermenterRecipe.Type.INSTANCE );
    }
}
