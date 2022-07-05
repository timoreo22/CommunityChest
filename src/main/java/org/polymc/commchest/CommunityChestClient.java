package org.polymc.commchest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CommunityChestClient implements ClientModInitializer {

    public static final Identifier SIMPLE = new Identifier("commuchest", "entity/chest/community_chest");
    public static final Identifier SIMPLE_LEFT = new Identifier("commuchest", "entity/chest/community_chest_left");
    public static final Identifier SIMPLE_RIGHT = new Identifier("commuchest", "entity/chest/community_chest_right");

    @Override
    public void onInitializeClient() {
        CommunityChest.LOGGER.info("Initalising client !!!");
        BlockEntityRendererRegistry.register(BlockEntityInitialiser.COMMUNITY_CHEST_ENTITY, CommunityChestBlockEntityRenderer::new);

        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(SIMPLE);
            registry.register(SIMPLE_LEFT);
            registry.register(SIMPLE_RIGHT);
        }));
    }
}
