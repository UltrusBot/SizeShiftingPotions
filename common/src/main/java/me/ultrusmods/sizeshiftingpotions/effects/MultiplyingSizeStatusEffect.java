package me.ultrusmods.sizeshiftingpotions.effects;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class MultiplyingSizeStatusEffect extends StatusEffect {
    private final ScaleType scaleType;

    public MultiplyingSizeStatusEffect(StatusEffectCategory mobEffectCategory, int i, ScaleType scaleType) {
        super(mobEffectCategory, i);
        this.scaleType = scaleType;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        double newScale = (amplifier + 1) * SizeShiftingPotionsConfig.sizeChangeFactor;
        newScale = Math.min(newScale, SizeShiftingPotionsConfig.maxSize);
        scaleData.setTargetScale((float) newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        scaleData.setTargetScale(1.0F);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }
}
