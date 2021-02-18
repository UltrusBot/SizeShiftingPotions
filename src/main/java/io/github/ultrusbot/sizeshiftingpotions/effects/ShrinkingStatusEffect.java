package io.github.ultrusbot.sizeshiftingpotions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class ShrinkingStatusEffect extends StatusEffect {
    public ShrinkingStatusEffect() {
        super(StatusEffectType.NEUTRAL, 0xcca468);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleType.BASE.getScaleData(entity);
        float newScale = scaleData.getScale() / ((amplifier+1)*2);
        newScale = Math.max(newScale, .1f);
        scaleData.setTargetScale(newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleType.BASE.getScaleData(entity);
        scaleData.setTargetScale(ScaleData.IDENTITY.getScale());
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }
}
