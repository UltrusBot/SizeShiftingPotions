package io.github.ultrusbot.sizeshiftingpotions.effects;

import io.github.ultrusbot.sizeshiftingpotions.PotionScaleModifier;
import io.github.ultrusbot.sizeshiftingpotions.SizeShiftingPotions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.*;

public class GrowingStatusEffect extends StatusEffect {
    public GrowingStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xc90000);
    }

    ScaleModifier GROWTH = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "growth"),
            new PotionScaleModifier(2.0f)
    );
    ScaleModifier GROWTH_II = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "growth_ii"),
            new PotionScaleModifier(4.0f)
    );

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.BASE.getScaleData(entity);

        scaleData.getBaseValueModifiers().add(amplifier == 0 ? GROWTH : GROWTH_II);
        scaleData.onUpdate();
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.BASE.getScaleData(entity);
        scaleData.getBaseValueModifiers().remove(amplifier == 0 ? GROWTH : GROWTH_II);
        scaleData.onUpdate();
    }
}
