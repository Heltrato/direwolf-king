package com.example.examplemod.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    // Fuck java. I cannot use generics without using weird looking casting shit.

    public PlayerRendererMixin(EntityRendererProvider.Context rendererManager,
                               PlayerModel<AbstractClientPlayer> entityModelIn, float shadowSizeIn) {
        super(rendererManager, entityModelIn, shadowSizeIn);
    }

    @Inject(at = @At("HEAD"), method = "renderRightHand(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;)V", cancellable = true)
    private void renderRightHand(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
                                 AbstractClientPlayer playerIn, CallbackInfo info) {
        if (checkMorphPresent(playerIn)) {
//			RenderHandler.checkCache(playerIn);
            info.cancel();

            EntityRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(playerIn);

            if (renderer instanceof LivingEntityRenderer<?, ?>) {
                ModelPart armRenderer = null;

                LivingEntityRenderer<? super LivingEntity, ?> living = (LivingEntityRenderer<? super LivingEntity, ?>) renderer;

                if (living.getModel() instanceof HumanoidModel<?>)
                    armRenderer = ((HumanoidModel<?>) living.getModel()).rightArm;

                if (living.getModel() instanceof QuadrupedModel<?>)

                    if (armRenderer != null) {

                    }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "renderLeftHand(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;)V", cancellable = true)
    private void renderLeftHand(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn,
                                AbstractClientPlayer playerIn, CallbackInfo info) {
        if (checkMorphPresent(playerIn)) {
            info.cancel();

            EntityRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(playerIn);

            if (renderer instanceof LivingEntityRenderer<?, ?>) {
                ModelPart armRenderer = null;

                LivingEntityRenderer<? super LivingEntity, ?> living = (LivingEntityRenderer<? super LivingEntity, ?>) renderer;

                if (living.getModel() instanceof HumanoidModel<?>)
                    armRenderer = ((HumanoidModel<?>) living.getModel()).rightArm;

                if (living.getModel() instanceof QuadrupedModel<?>)

                    if (armRenderer != null) {

                    }
            }
        }
    }

    private boolean checkMorphPresent(Player player) {
        return player != null;
    }
}