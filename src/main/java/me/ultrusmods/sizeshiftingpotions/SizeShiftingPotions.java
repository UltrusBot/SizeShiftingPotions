package me.ultrusmods.sizeshiftingpotions;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import me.ultrusmods.sizeshiftingpotions.effects.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class    SizeShiftingPotions implements ModInitializer {
    public static final String MOD_ID = "sizeshiftingpotions";

    public static final StatusEffect GROWING = new MultiplyingSizeStatusEffect(StatusEffectType.NEUTRAL, 0xc90000, CustomScaleTypes.SIZE);
    public static Potion GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 3600));
    public static Potion LONG_GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 9600));
    public static Potion STRONG_GROWING_POTION = new Potion(new StatusEffectInstance(GROWING, 1800, 1));

    public static final StatusEffect SHRINKING = new DividingSizeStatusEffect(StatusEffectType.NEUTRAL, 0xcca468, CustomScaleTypes.SIZE);
    public static Potion SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 3600));
    public static Potion LONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 9600));
    public static Potion STRONG_SHRINKING_POTION = new Potion(new StatusEffectInstance(SHRINKING, 1800, 1));

    public static final StatusEffect WIDENING = new MultiplyingSizeStatusEffect(StatusEffectType.NEUTRAL, 0xb3ffc2, CustomScaleTypes.THICKNESS);
    public static Potion WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 3600));
    public static Potion LONG_WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 9600));
    public static Potion STRONG_WIDENING_POTION = new Potion(new StatusEffectInstance(WIDENING, 1800, 1));

    public static final StatusEffect THINNING = new DividingSizeStatusEffect(StatusEffectType.NEUTRAL, 0xe3b3ff, CustomScaleTypes.THICKNESS);
    public static Potion THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 3600));
    public static Potion LONG_THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 9600));
    public static Potion STRONG_THINNING_POTION = new Potion(new StatusEffectInstance(THINNING, 1800, 1));

    @Override
    public void onInitialize() {

        CustomScaleTypes.init();
        MidnightConfig.init(MOD_ID, SizeShiftingPotionsConfig.class);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "shrinking"), SHRINKING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "growing"), GROWING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "widening"), WIDENING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "thinning"), THINNING);

        SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking"), SHRINKING_POTION);
        LONG_SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking_long"), LONG_SHRINKING_POTION);
        STRONG_SHRINKING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "shrinking_strong"), STRONG_SHRINKING_POTION);

        GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing"), GROWING_POTION);
        LONG_GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing_long"), LONG_GROWING_POTION);
        STRONG_GROWING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "growing_strong"), STRONG_GROWING_POTION);

        WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening"), WIDENING_POTION);
        LONG_WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening_long"), LONG_WIDENING_POTION);
        STRONG_WIDENING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "widening_strong"), STRONG_WIDENING_POTION);

        THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning"), THINNING_POTION);
        LONG_THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning_long"), LONG_THINNING_POTION);
        STRONG_THINNING_POTION = Registry.register(Registry.POTION, new Identifier(MOD_ID, "thinning_strong"), STRONG_THINNING_POTION);
    }
}
