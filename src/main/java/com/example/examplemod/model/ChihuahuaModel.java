package com.example.examplemod.model;

import com.example.examplemod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class ChihuahuaModel extends AnimatedTickingGeoModel {
    @Override
    public ResourceLocation getModelResource(Object o) {
        return new ResourceLocation(ExampleMod.MODID, "geo/chihuahua.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Object o) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/chihuahua.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Object o) {
        return new ResourceLocation(ExampleMod.MODID, "animations/chihuahua.animation.json");
    }
}
