package dev.backupcup.plushified.mixin;

import dev.backupcup.plushified.register.RegisterItems;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//Banner Item Slot
@Mixin(targets = "net.minecraft.world.inventory.LoomMenu$3")
public class LoomBannerSlotMixin {
    @Inject(method = "mayPlace", at = @At("RETURN"), cancellable = true)
    private void onMayPlace(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        //cir.setReturnValue(itemStack.is(Items.WHITE_WOOL) || itemStack.getItem() instanceof BannerItem);
    }
}
