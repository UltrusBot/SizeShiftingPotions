package io.github.ultrusbot.sizeshiftingpotions.mixin;

import io.github.ultrusbot.sizeshiftingpotions.SizeShiftingPotions;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class PotionRecipeMixinShrinking {

    @Shadow
    private static void registerPotionRecipe(Potion input, Item item, Potion output){
        throw new RuntimeException("Potion of Shrinking Mod Mixin, this should not be running!");
    }
    @Inject(at = @At("TAIL"), method = "registerDefaults()V")
    private static void RegisterDefaults(CallbackInfo ci) {
        registerPotionRecipe(Potions.AWKWARD, Items.BROWN_MUSHROOM, SizeShiftingPotions.SHRINKING_POTION);
        registerPotionRecipe(SizeShiftingPotions.SHRINKING_POTION, Items.REDSTONE, SizeShiftingPotions.LONG_SHRINKING_POTION);
        registerPotionRecipe(SizeShiftingPotions.SHRINKING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotions.STRONG_SHRINKING_POTION);

        registerPotionRecipe(Potions.AWKWARD, Items.RED_MUSHROOM, SizeShiftingPotions.GROWING_POTION);
        registerPotionRecipe(SizeShiftingPotions.GROWING_POTION, Items.REDSTONE, SizeShiftingPotions.LONG_GROWING_POTION);
        registerPotionRecipe(SizeShiftingPotions.GROWING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotions.STRONG_GROWING_POTION);

        registerPotionRecipe(SizeShiftingPotions.GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.WIDENING_POTION);
        registerPotionRecipe(SizeShiftingPotions.STRONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.STRONG_WIDENING_POTION);
        registerPotionRecipe(SizeShiftingPotions.LONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.LONG_WIDENING_POTION);

        registerPotionRecipe(SizeShiftingPotions.SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.THINNING_POTION);
        registerPotionRecipe(SizeShiftingPotions.STRONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.STRONG_THINNING_POTION);
        registerPotionRecipe(SizeShiftingPotions.LONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotions.LONG_THINNING_POTION);


    }
}
