package com.example.examplemod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CustomItemGroup extends CreativeModeTab {

    public static final CreativeModeTab NEW_TAB = new CustomItemGroup("custom_item_group");

    public CustomItemGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ExampleMod.WOLF_AMULET_JOHNNY.get());
    }
}
