package me.ultrusmods.sizeshiftingpotions.effects;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class DividingSizeStatusEffect extends StatusEffect {
    private final ScaleType scaleType;

    public DividingSizeStatusEffect(StatusEffectType statusEffectType, int i, ScaleType scaleType) {
        super(statusEffectType, i);
        this.scaleType = scaleType;
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        double newScale = 1.0D / ((amplifier + 1) * 2);
        newScale = Math.max(newScale, SizeShiftingPotionsConfig.minSize);
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
