package net.codenamed.flavored.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Equipment;

public class WearableCarvedMelonBlock extends CarvedMelonBlock implements Equipment {
    public WearableCarvedMelonBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}