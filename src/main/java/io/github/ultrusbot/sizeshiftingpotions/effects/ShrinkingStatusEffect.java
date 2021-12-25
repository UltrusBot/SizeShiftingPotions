package io.github.ultrusbot.sizeshiftingpotions.effects;

import io.github.ultrusbot.sizeshiftingpotions.PotionScaleModifier;
import io.github.ultrusbot.sizeshiftingpotions.SizeShiftingPotions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.*;

public class ShrinkingStatusEffect extends StatusEffect {
    public ShrinkingStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xcca468);
    }

    private static final ScaleModifier SHRINK = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "shrink"),
            new PotionScaleModifier(0.5f)
    );
    private static final ScaleModifier SHRINK_II = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "shrink_ii"),
            new PotionScaleModifier(0.25f)
    );

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.BASE.getScaleData(entity);

        scaleData.getBaseValueModifiers().add(amplifier == 0 ? SHRINK : SHRINK_II);
        scaleData.onUpdate();
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.BASE.getScaleData(entity);
        scaleData.getBaseValueModifiers().remove(amplifier == 0 ? SHRINK : SHRINK_II);
        scaleData.onUpdate();
    }
}
