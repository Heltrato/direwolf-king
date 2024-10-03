package com.example.examplemod.mixin;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {
    @Inject(at = @At("TAIL"), method = "serverAiStep")
    private void serverAiStep(CallbackInfo callback) {
        LocalPlayer thisObj = (LocalPlayer) ((Object) this);

        if (isControlledCamera()) {
        }
    }

    @Shadow
    public abstract boolean isControlledCamera();
}