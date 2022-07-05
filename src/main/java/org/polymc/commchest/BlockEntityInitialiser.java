package org.polymc.commchest;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityInitialiser {

    public static BlockEntityType<CommunityChestBlockEntity> COMMUNITY_CHEST_ENTITY;

    public static void register() {
        COMMUNITY_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("commuchest", "community_chest"), FabricBlockEntityTypeBuilder.create(CommunityChestBlockEntity::new, CommunityChest.COMMUNITY_CHEST).build(null));
    }
}
