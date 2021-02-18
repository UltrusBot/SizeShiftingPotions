package io.github.ultrusbot.sizeshiftingpotions;

import io.github.ultrusbot.sizeshiftingpotions.effects.GrowingStatusEffect;
import io.github.ultrusbot.sizeshiftingpotions.effects.ShrinkingStatusEffect;
import io.github.ultrusbot.sizeshiftingpotions.effects.ThinningStatusEffect;
import io.github.ultrusbot.sizeshiftingpotions.effects.WideningStatusEffect;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SizeShiftingPotions implements ModInitializer {
    public static final String MOD_ID = "sizeshiftingpotions";
    public static final StatusEffect SHRINKING = new ShrinkingStatusEffect();
    public static Potion SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 3600));
    public static Potion LONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 9600));
    public static Potion STRONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 1800, 1));


    public static final StatusEffect GROWING = new GrowingStatusEffect();
    public static Potion GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 3600));
    public static Potion LONG_GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 9600));
    public static Potion STRONG_GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 1800, 1));

    public static final StatusEffect WIDENING = new WideningStatusEffect();
    public static Potion WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 3600));
    public static Potion LONG_WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 9600));
    public static Potion STRONG_WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 1800, 1));


    public static final StatusEffect THINNING = new ThinningStatusEffect();
    public static Potion THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 3600));
    public static Potion LONG_THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 9600));
    public static Potion STRONG_THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 1800, 1));

    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "shrinking"), SHRINKING);
        SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking"), SHRINKING_POTION);
        LONG_SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking_long"), LONG_SHRINKING_POTION);
        STRONG_SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking_strong"), STRONG_SHRINKING_POTION);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "growing"), GROWING);
        GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing"), GROWING_POTION);
        LONG_GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing_long"), LONG_GROWING_POTION);
        STRONG_GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing_strong"), STRONG_GROWING_POTION);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "widening"), WIDENING);
        WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening"), WIDENING_POTION);
        LONG_WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening_long"), LONG_WIDENING_POTION);
        STRONG_WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening_strong"), STRONG_WIDENING_POTION);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "thinning"), THINNING);
        THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning"), THINNING_POTION);
        LONG_THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning_long"), LONG_THINNING_POTION);
        STRONG_THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning_strong"), STRONG_THINNING_POTION);

    }
}
