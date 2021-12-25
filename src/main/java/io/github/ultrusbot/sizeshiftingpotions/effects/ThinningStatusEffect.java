package io.github.ultrusbot.sizeshiftingpotions.effects;

import io.github.ultrusbot.sizeshiftingpotions.PotionScaleModifier;
import io.github.ultrusbot.sizeshiftingpotions.SizeShiftingPotions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.*;

public class ThinningStatusEffect extends StatusEffect {
    public ThinningStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xe3b3ff);
    }

    ScaleModifier THIN = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "thin"),
            new PotionScaleModifier(0.5f)
    );
    ScaleModifier THIN_II = ScaleRegistries.register(
            ScaleRegistries.SCALE_MODIFIERS,
            new Identifier(SizeShiftingPotions.MOD_ID, "thin_ii"),
            new PotionScaleModifier(0.25f)
    );

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.WIDTH.getScaleData(entity);

        scaleData.getBaseValueModifiers().add(amplifier == 0 ? THIN : THIN_II);
        scaleData.onUpdate();
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        ScaleData scaleData = ScaleTypes.WIDTH.getScaleData(entity);
        scaleData.getBaseValueModifiers().remove(amplifier == 0 ? THIN : THIN_II);
        scaleData.onUpdate();
    }
}
