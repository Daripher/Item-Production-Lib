package daripher.itemproduction.mixin.farmersdelight;

import daripher.itemproduction.ItemProductionLib;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

@Mixin(value = CookingPotBlockEntity.class, remap = false)
public class CookingPotBlockEntityMixin {
    @ModifyVariable(method = "processCooking", at = @At(value = "STORE", ordinal = 0), ordinal = 0, remap = false)
    private ItemStack itemProduced(ItemStack original) {
        @SuppressWarnings("DataFlowIssue") CookingPotBlockEntity blockEntity = (CookingPotBlockEntity) (Object) this;
        return ItemProductionLib.itemProduced(original, blockEntity);
    }
}
