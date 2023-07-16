package me.ultrusmods.sizeshiftingpotions.forge;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpotions.Constants;
import me.ultrusmods.sizeshiftingpotions.SizeShiftingPotionsCommon;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class SizeShiftingPotionsForge {
    
    public SizeShiftingPotionsForge() {
        MidnightConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfig.class);
        SizeShiftingPotionsCommon.init();
//        FMLJavaModLoadingContext.getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::register);
    }

    private void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.MOB_EFFECTS, helper -> SizeShiftingPotionsEffects.register(helper::register));
        event.register(ForgeRegistries.Keys.POTIONS, helper -> SizeShiftingPotionsPotions.register(helper::register));
    }


    public void onCommonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                final Item growItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.CRIMSON_FUNGUS : Items.RED_MUSHROOM;
                final Item shrinkItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.WARPED_FUNGUS : Items.BROWN_MUSHROOM;
                if (SizeShiftingPotionsConfig.growingPotion) {
                    addBrewingRecipe(Potions.STRENGTH, growItem, SizeShiftingPotionsPotions.GROWING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_GROWING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_GROWING_POTION);
                }

                if (SizeShiftingPotionsConfig.shrinkingPotion) {
                    addBrewingRecipe(Potions.WEAKNESS, shrinkItem, SizeShiftingPotionsPotions.SHRINKING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_SHRINKING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION);
                }

                if (SizeShiftingPotionsConfig.wideningPotion) {
                    addBrewingRecipe(SizeShiftingPotionsPotions.GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.WIDENING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.STRONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_WIDENING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.LONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_WIDENING_POTION);
                }
                if (SizeShiftingPotionsConfig.thinningPotion) {
                    addBrewingRecipe(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.THINNING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_THINNING_POTION);
                    addBrewingRecipe(SizeShiftingPotionsPotions.LONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_THINNING_POTION);
                }
            });
    }

    private void addBrewingRecipe(Potion inputPotion, Item brewingItem, Potion outputPotion) {
        BrewingRecipeRegistry.addRecipe(StrictNBTIngredient.of(PotionUtil.setPotion(new ItemStack(Items.POTION), inputPotion)), Ingredient.ofItems(brewingItem), PotionUtil.setPotion(new ItemStack(Items.POTION), outputPotion));
    }

}