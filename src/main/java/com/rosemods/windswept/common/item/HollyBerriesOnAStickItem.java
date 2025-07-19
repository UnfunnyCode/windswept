package com.rosemods.windswept.common.item;

import com.rosemods.windswept.common.entity.animal.Frostbiter;
import com.rosemods.windswept.core.registry.WindsweptEntityTypes;

import net.minecraft.world.item.FoodOnAStickItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class HollyBerriesOnAStickItem extends FoodOnAStickItem<Frostbiter> {


    public HollyBerriesOnAStickItem(Properties properties, int consumeItemDamage) {
        super(properties, WindsweptEntityTypes.FROSTBITER.get(), consumeItemDamage);
    }



}
