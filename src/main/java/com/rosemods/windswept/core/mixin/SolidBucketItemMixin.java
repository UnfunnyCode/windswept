package com.rosemods.windswept.core.mixin;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SolidBucketItem.class)
public class SolidBucketItemMixin extends Item {

    protected SolidBucketItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return !this.hasCraftingRemainingItem() ? Items.BUCKET.getDefaultInstance() : super.getCraftingRemainingItem(itemStack);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

}
