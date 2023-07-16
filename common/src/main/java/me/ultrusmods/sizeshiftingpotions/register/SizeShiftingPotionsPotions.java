package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

// Gotta stick with my name convention, even if it leads to this.
public class SizeShiftingPotionsPotions {

    public static Potion GROWING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.GROWING, 3600));
    public static Potion LONG_GROWING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.GROWING, 9600));
    public static Potion STRONG_GROWING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.GROWING, 1800, 1));

    public static Potion SHRINKING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 3600));
    public static Potion LONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 9600));
    public static Potion STRONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 1800, 1));

    public static Potion WIDENING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.WIDENING, 3600));
    public static Potion LONG_WIDENING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.WIDENING, 9600));
    public static Potion STRONG_WIDENING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.WIDENING, 1800, 1));

    public static Potion THINNING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.THINNING, 3600));
    public static Potion LONG_THINNING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.THINNING, 9600));
    public static Potion STRONG_THINNING_POTION = new Potion(new StatusEffectInstance(SizeShiftingPotionsEffects.THINNING, 1800, 1));
    
    public static void register(BiConsumer<Identifier, Potion> consumer) {
        consumer.accept(new Identifier(Constants.MOD_ID, "growing"), GROWING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "growing_long"), LONG_GROWING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "growing_strong"), STRONG_GROWING_POTION);

        consumer.accept(new Identifier(Constants.MOD_ID, "shrinking"), SHRINKING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "shrinking_long"), LONG_SHRINKING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "shrinking_strong"), STRONG_SHRINKING_POTION);

        consumer.accept(new Identifier(Constants.MOD_ID, "widening"), WIDENING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "widening_long"), LONG_WIDENING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "widening_strong"), STRONG_WIDENING_POTION);

        consumer.accept(new Identifier(Constants.MOD_ID, "thinning"), THINNING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "thinning_long"), LONG_THINNING_POTION);
        consumer.accept(new Identifier(Constants.MOD_ID, "thinning_strong"), STRONG_THINNING_POTION);
    }
}
