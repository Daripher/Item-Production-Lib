package daripher.itemproduction.mixin.farmersdelight;

import daripher.itemproduction.ItemProductionLib;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import vectorwing.farmersdelight.common.block.entity.AbstractStoveBlockEntity;
import vectorwing.farmersdelight.common.block.entity.StoveBlockEntity;

@Mixin(value = AbstractStoveBlockEntity.class)
public class AbstractStoveBlockEntityMixin {
    @ModifyVariable(method = "cookAndOutputItems", at = @At(value = "STORE", ordinal = 0), ordinal = 1, remap = false)
    private ItemStack itemProduced(ItemStack original) {
        @SuppressWarnings("DataFlowIssue") AbstractStoveBlockEntity blockEntity = (AbstractStoveBlockEntity) (Object) this;
        return ItemProductionLib.itemProduced(original, blockEntity);
    }
}
