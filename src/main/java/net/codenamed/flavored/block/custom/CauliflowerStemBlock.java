package net.codenamed.flavored.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class CauliflowerStemBlock extends StemBlock {


    public CauliflowerStemBlock(GourdBlock gourdBlock, Supplier<Item> pickBlockItem, Settings settings) {
        super(gourdBlock, pickBlockItem, settings);
    }
}
