package dev.backupcup.plushified.datagen;

import dev.backupcup.plushified.register.RegisterBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class PlushBlockLootTables extends BlockLootSubProvider {
    protected PlushBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        RegisterBlocks.PLUSHIES.forEach(plushie -> {
            this.dropSelf(plushie.getBlock().get());
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegisterBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
