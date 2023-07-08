package me.ultrusmods.sizeshiftingpotions.effects;

import me.ultrusmods.sizeshiftingpotions.platform.Services;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class DividingSizeStatusEffect extends MobEffect {
    private final ScaleType scaleType;

    public DividingSizeStatusEffect(MobEffectCategory mobEffectCategory, int i, ScaleType scaleType) {
        super(mobEffectCategory, i);
        this.scaleType = scaleType;
    }


    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(entity);
        double newScale = 1.0D / ((amplifier + 1) * Services.PLATFORM.getSizeChangeFactor());
        newScale = Math.max(newScale, Services.PLATFORM.getMinSize());
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





