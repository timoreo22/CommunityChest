package org.polymc.commchest;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class CommunityChestBlockEntity extends ChestBlockEntity {
    public CommunityChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInitialiser.COMMUNITY_CHEST_ENTITY,pos, state);
    }


    @Override
    protected Text getContainerName() {
        return new TranslatableText("block.commuchest.community_chest");
    }
}
