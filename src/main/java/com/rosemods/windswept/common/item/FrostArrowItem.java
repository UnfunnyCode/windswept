package com.rosemods.windswept.common.item;

import com.rosemods.windswept.common.entity.projectile.FrostArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class FrostArrowItem extends SpectralArrowItem {

    public FrostArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity livingEntity) {
        return new FrostArrow(level, livingEntity);
    }



}
