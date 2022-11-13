package me.ultrusmods.sizeshiftingpotions.effects;

import me.ultrusmods.sizeshiftingpotions.platform.Services;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class MultiplyingSizeStatusEffect extends MobEffect {
    private final ScaleType scaleType;

    public MultiplyingSizeStatusEffect(MobEffectCategory mobEffectCategory, int i, ScaleType scaleType) {
        super(mobEffectCategory, i);
        this.scaleType = scaleType;
    }


    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        double newScale = (amplifier + 1) * 2;
        newScale = Math.min(newScale, Services.PLATFORM.getMaxSize());
        scaleData.setTargetScale((float) newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        scaleData.setTargetScale(1.0F);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }
}
