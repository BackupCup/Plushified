package dev.backupcup.plushified.register;

import dev.backupcup.plushified.Constants;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<Item> PALETTE = ITEMS.register("palette", () -> new Item(new Item.Properties()
            .stacksTo(64)
    ));
}
