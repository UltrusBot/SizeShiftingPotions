package me.ultrusmods.sizeshiftingpotions.mixin;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
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
public abstract class BrewingRecipeRegistryMixin {


    @Shadow
    public static void registerPotionRecipe(Potion input, Item item, Potion output) {
    }

    @Inject(at = @At("TAIL"), method = "registerDefaults()V")
    private static void RegisterDefaults(CallbackInfo ci) {
        final Item growItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.CRIMSON_FUNGUS : Items.RED_MUSHROOM;
        final Item shrinkItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.WARPED_FUNGUS : Items.BROWN_MUSHROOM;

        if (SizeShiftingPotionsConfig.growingPotion) {
            registerPotionRecipe(Potions.STRENGTH, growItem, SizeShiftingPotionsPotions.GROWING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_GROWING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_GROWING_POTION);
        }

        if (SizeShiftingPotionsConfig.shrinkingPotion) {
            registerPotionRecipe(Potions.WEAKNESS, shrinkItem, SizeShiftingPotionsPotions.SHRINKING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_SHRINKING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION);
        }

        if (SizeShiftingPotionsConfig.wideningPotion) {
            registerPotionRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.WIDENING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.STRONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_WIDENING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.LONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_WIDENING_POTION);
        }
        if (SizeShiftingPotionsConfig.thinningPotion) {
            registerPotionRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.THINNING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_THINNING_POTION);
            registerPotionRecipe(SizeShiftingPotionsPotions.LONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_THINNING_POTION);
        }

    }
}
