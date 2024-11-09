package dev.backupcup.plushified;

import dev.backupcup.plushified.register.RegisterBlocks;
import dev.backupcup.plushified.register.RegisterItems;
import dev.backupcup.plushified.register.RegisterTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class Plushified {
    public Plushified() {
        Constants.LOG.info("GO MY SCARAB");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegisterBlocks.BLOCKS.register(modEventBus);
        RegisterBlocks.BLOCK_ITEMS.register(modEventBus);
        RegisterItems.ITEMS.register(modEventBus);
        RegisterTabs.CREATIVE_MODE_TABS.register(modEventBus);

        CommonClass.init();
    }
}