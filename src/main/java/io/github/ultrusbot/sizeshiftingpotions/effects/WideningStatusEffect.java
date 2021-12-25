package io.github.ultrusbot.sizeshiftingpotions.effects;

import io.github.ultrusbot.sizeshiftingpotions.PotionScaleModifier;
import io.github.ultrusbot.sizeshiftingpotions.SizeShiftingPotions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.*;

public class WideningStatusEffect extends StatusEffect {
    public WideningStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xb3ffc2);
    }

    ScaleModifier WIDE = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "wide"),
            new PotionScaleModifier(2.0f)
    );
    ScaleModifier WIDE_II = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "wide_ii"),
            new PotionScaleModifier(4.0f)
    );

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.WIDTH.getScaleData(entity);

        scaleData.getBaseValueModifiers().add(amplifier == 0 ? WIDE : WIDE_II);
        scaleData.onUpdate();
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.WIDTH.getScaleData(entity);
        scaleData.getBaseValueModifiers().remove(amplifier == 0 ? WIDE : WIDE_II);
        scaleData.onUpdate();
    }
}
