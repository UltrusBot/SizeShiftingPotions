package me.ultrusmods.sizeshiftingpotions;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfigForge;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class SizeShiftingPotionsForge {
    
    public SizeShiftingPotionsForge() {
        MidnightConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfigForge.class);
        SizeShiftingPotionsCommon.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }


    public void onCommonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                final Item growItem = SizeShiftingPotionsConfigForge.useNetherFungus ? Items.CRIMSON_FUNGUS : Items.RED_MUSHROOM;
                final Item shrinkItem = SizeShiftingPotionsConfigForge.useNetherFungus ? Items.WARPED_FUNGUS : Items.BROWN_MUSHROOM;
                if (SizeShiftingPotionsConfigForge.growingPotion) {
                    addBrewingRecipe(Potions.STRENGTH, growItem, SizeShiftingPotionsPotions.GROWING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.REDSTONE, SizeShiftingPotionsPotions.LONG_GROWING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_GROWING_POTION.get());
                }

                if (SizeShiftingPotionsConfigForge.shrinkingPotion) {
                    addBrewingRecipe(Potions.WEAKNESS, shrinkItem, SizeShiftingPotionsPotions.SHRINKING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.REDSTONE, SizeShiftingPotionsPotions.LONG_SHRINKING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION.get());
                }

                if (SizeShiftingPotionsConfigForge.wideningPotion) {
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.WIDENING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.STRONG_GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_WIDENING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.LONG_GROWING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_WIDENING_POTION.get());
                }
                if (SizeShiftingPotionsConfigForge.thinningPotion) {
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.THINNING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_THINNING_POTION.get());
                    addBrewingRecipe(SizeShiftingPotionsPotions.LONG_SHRINKING_POTION.get(), Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_THINNING_POTION.get());
                }
            });
    }

    private void addBrewingRecipe(Potion inputPotion, Item brewingItem, Potion outputPotion) {
        BrewingRecipeRegistry.addRecipe(StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), inputPotion)), Ingredient.of(brewingItem), PotionUtils.setPotion(new ItemStack(Items.POTION), outputPotion));
    }

}