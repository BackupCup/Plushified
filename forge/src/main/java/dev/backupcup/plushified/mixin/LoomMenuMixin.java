package dev.backupcup.plushified.mixin;

import dev.backupcup.plushified.register.RegisterItems;
import net.minecraft.core.Holder;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LoomMenu.class)
public class LoomMenuMixin {
    @Shadow private List<Holder<BannerPattern>> selectablePatterns;

    @Shadow @Final private Slot bannerSlot;

    @Inject(method = "slotsChanged", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/DataSlot;get()I"), cancellable = true)
    private void plushieList(Container container, CallbackInfo ci) {
        if (bannerSlot.getItem().is(Items.WHITE_WOOL) ^ bannerSlot.getItem().is(RegisterItems.PALETTE.get())) ci.cancel();
    }
}