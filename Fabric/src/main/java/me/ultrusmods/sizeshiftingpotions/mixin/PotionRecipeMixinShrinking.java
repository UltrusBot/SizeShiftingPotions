package me.ultrusmods.sizeshiftingpotions.mixin;

import me.ultrusmods.sizeshiftingpotions.SizeShiftingPotionsCommon;
import me.ultrusmods.sizeshiftingpotions.platform.Services;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public abstract class PotionRecipeMixinShrinking {

    @Shadow
    private static void addMix(Potion input, Item item, Potion output) {
        throw new RuntimeException("Size Shifting Potions Mod Mixin, this should not be running!");
    }


    @Inject(at = @At("TAIL"), method = "bootStrap()V")
    private static void RegisterDefaults(CallbackInfo ci) {
        final Item growItem = Services.PLATFORM.getUseNetherFungus() ? Items.CRIMSON_FUNGUS : Items.RED_MUSHROOM;
        final Item shrinkItem = Services.PLATFORM.getUseNetherFungus() ? Items.WARPED_FUNGUS : Items.BROWN_MUSHROOM;

        if (Services.PLATFORM.getGrowingPotion()) {
            addMix(Potions.STRENGTH, growItem, SizeShiftingPotionsPotions.GROWING_POTION.get());
            addMix(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.REDSTONE, SizeShiftingPotionsPotions.LONG_GROWING_POTION.get());
            addMix(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_GROWING_POTION.get());
        }

        if (Services.PLATFORM.getShrinkingPotion()) {
            addMix(Potions.WEAKNESS, shrinkItem, SizeShiftingPotionsPotions.SHRINKING_POTION.get());
            addMix(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.REDSTONE, SizeShiftingPotionsPotions.LONG_SHRINKING_POTION.get());
            addMix(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION.get());
        }

        if (Services.PLATFORM.getWideningPotion()) {
            addMix(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.WIDENING_POTION.get());
            addMix(SizeShiftingPotionsPotions.STRONG_GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_WIDENING_POTION.get());
            addMix(SizeShiftingPotionsPotions.LONG_GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_WIDENING_POTION.get());
        }
        if (Services.PLATFORM.getThinningPotion()) {
            addMix(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.THINNING_POTION.get());
            addMix(SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_THINNING_POTION.get());
            addMix(SizeShiftingPotionsPotions.LONG_SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_THINNING_POTION.get());
        }

    }
}
