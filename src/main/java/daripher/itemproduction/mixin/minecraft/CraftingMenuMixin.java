package daripher.itemproduction.mixin.minecraft;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import daripher.itemproduction.ItemProductionLib;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingMenu.class)
public class CraftingMenuMixin {
  @Inject(
      method = "slotChangedCraftingGrid",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/inventory/ResultContainer;"
                      + "setItem(ILnet/minecraft/world/item/ItemStack;)V",
              shift = At.Shift.BEFORE))
  private static void itemProduced(
      AbstractContainerMenu pMenu,
      Level level,
      Player player,
      CraftingContainer container,
      ResultContainer result,
      CallbackInfo callbackInfo,
      @Local(ordinal = 0) LocalRef<ItemStack> stack) {
    stack.set(ItemProductionLib.itemProduced(stack.get(), player));
  }
}
