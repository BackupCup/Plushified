package dev.backupcup.plushified.register;

import dev.backupcup.plushified.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RegisterTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PLUSHIE_TAB = CREATIVE_MODE_TABS.register("plushie_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.plushies"))
                    .icon(() -> new ItemStack(RegisterBlocks.PLUSHIES.get(0).getItem().get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        RegisterBlocks.PLUSHIES.forEach(plushie -> output.accept(plushie.getItem().get()));
                        RegisterItems.PALETTE.get();
                    }))
            .build()
    );
}
