package dev.backupcup.plushified.datagen;

import dev.backupcup.plushified.Constants;
import dev.backupcup.plushified.register.RegisterBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class PlushBlockstateProvider extends BlockStateProvider {
    public PlushBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        RegisterBlocks.PLUSHIES.forEach(plushie -> {
            blockWithItem(plushie.getBlock());
        });
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
