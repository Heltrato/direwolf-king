package com.example.examplemod;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.ProfilePublicKey;
import org.jetbrains.annotations.Nullable;

public class AdvanceAbstractPlayer extends AbstractClientPlayer {

    public ResourceLocation skinResourceLocation = DefaultPlayerSkin.getDefaultSkin(getUUID());
    public String modelName;
    public AdvanceAbstractPlayer(ClientLevel p_234112_, GameProfile p_234113_, @Nullable ProfilePublicKey p_234114_) {
        super(p_234112_, p_234113_, p_234114_);
    }

    public ResourceLocation getSkinResourceLocation() {
        return skinResourceLocation;
    }

    @Override
    public String getModelName()
    {
        return modelName == null ? DefaultPlayerSkin.getSkinModelName(this.getUUID()) : modelName;
    }

}
