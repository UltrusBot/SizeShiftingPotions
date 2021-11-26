package io.github.ultrusbot.sizeshiftingpotions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class GrowingStatusEffect extends StatusEffect {
    public GrowingStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xc90000);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleType.BASE.getScaleData(entity);
        float newScale = scaleData.getScale() * ((amplifier+1)*2);
        newScale = Math.min(newScale, 10f);
        scaleData.setTargetScale(newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData newScale = ScaleType.BASE.getScaleData(entity);
        newScale.fromScale(ScaleData.IDENTITY);
    }
}
