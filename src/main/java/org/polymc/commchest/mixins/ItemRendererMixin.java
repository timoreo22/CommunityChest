package org.polymc.commchest.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.polymc.commchest.CommunityChest;
import org.polymc.commchest.CommunityChestBlock;
import org.polymc.commchest.CommunityChestBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class ItemRendererMixin {
    private static final CommunityChestBlockEntity CHEST_ENTITY = new CommunityChestBlockEntity(BlockPos.ORIGIN, CommunityChest.COMMUNITY_CHEST.getDefaultState());
    @Final
    @Shadow
    private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    @Inject(method = "render", at=@At("HEAD"), cancellable = true)
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci){
        Item item = stack.getItem();
        if(item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();
            if(block instanceof CommunityChestBlock) {
                //manually render, mojang can't do it for some reason
                blockEntityRenderDispatcher.renderEntity(CHEST_ENTITY, matrices, vertexConsumers, light, overlay);
                ci.cancel();
            }
        }
    }
}
