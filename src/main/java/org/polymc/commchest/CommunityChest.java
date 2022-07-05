package org.polymc.commchest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunityChest implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("commuchest");

    public static final Block COMMUNITY_CHEST = new CommunityChestBlock(()-> BlockEntityInitialiser.COMMUNITY_CHEST_ENTITY);

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("commuchest","community_chest"), COMMUNITY_CHEST);
        Registry.register(Registry.ITEM, new Identifier("commuchest", "community_chest"), new BlockItem(COMMUNITY_CHEST, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        BlockEntityInitialiser.register();
        LOGGER.info("Hello Fabric world!");
    }
}
