package net.codenamed.flavored.block.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Equipment;

public class WearableCarvedCauliflowerBlock extends CarvedCauliflowerBlock implements Equipment {
    public WearableCarvedCauliflowerBlock(Settings settings) {
        super(settings);
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}