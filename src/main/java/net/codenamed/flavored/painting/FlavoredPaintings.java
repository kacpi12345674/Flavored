package net.codenamed.flavored.painting;

import net.codenamed.flavored.Flavored;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FlavoredPaintings {
    public static final PaintingVariant PLENTY = registerPainting("plenty", new PaintingVariant(32, 16));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(Flavored.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        Flavored.LOGGER.debug("Registering Paintings for " + Flavored.MOD_ID);
    }
}