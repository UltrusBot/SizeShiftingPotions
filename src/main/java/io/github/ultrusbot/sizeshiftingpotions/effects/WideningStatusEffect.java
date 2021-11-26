package io.github.ultrusbot.sizeshiftingpotions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class WideningStatusEffect extends StatusEffect {
    public WideningStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xb3ffc2);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleType.WIDTH.getScaleData(entity);
        float newScale = scaleData.getScale() * ((amplifier+1)*2);
        newScale = Math.min(newScale, 10f);
        scaleData.setTargetScale(newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData newScale = ScaleType.WIDTH.getScaleData(entity);
        newScale.fromScale(ScaleData.IDENTITY);
    }
}
