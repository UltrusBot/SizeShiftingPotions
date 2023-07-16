package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import me.ultrusmods.sizeshiftingpotions.CustomScaleTypes;
import me.ultrusmods.sizeshiftingpotions.effects.DividingSizeStatusEffect;
import me.ultrusmods.sizeshiftingpotions.effects.MultiplyingSizeStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class SizeShiftingPotionsEffects {
    public static final StatusEffect GROWING = new MultiplyingSizeStatusEffect(StatusEffectCategory.NEUTRAL, 0xda086a, CustomScaleTypes.SIZE);
    public static final StatusEffect SHRINKING = new DividingSizeStatusEffect(StatusEffectCategory.NEUTRAL, 0xcca468, CustomScaleTypes.SIZE);
    public static final StatusEffect WIDENING = new MultiplyingSizeStatusEffect(StatusEffectCategory.NEUTRAL, 0xb3ffc2, CustomScaleTypes.THICKNESS);
    public static final StatusEffect THINNING = new DividingSizeStatusEffect(StatusEffectCategory.NEUTRAL, 0xe3b3ff, CustomScaleTypes.THICKNESS);

    public static void register(BiConsumer<Identifier, StatusEffect> consumer) {
        consumer.accept(new Identifier(Constants.MOD_ID, "growing"), GROWING);
        consumer.accept(new Identifier(Constants.MOD_ID, "shrinking"), SHRINKING);
        consumer.accept(new Identifier(Constants.MOD_ID, "widening"), WIDENING);
        consumer.accept(new Identifier(Constants.MOD_ID, "thinning"), THINNING);
    }
}
