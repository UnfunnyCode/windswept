package com.rosemods.windswept.common.item;

import net.minecraft.world.item.Item;

public class InjectedItem extends Item {
	private final Item followItem;

	public InjectedItem(Item followItem, Properties properties) {
		super(properties);
		this.followItem = followItem;
	}

}