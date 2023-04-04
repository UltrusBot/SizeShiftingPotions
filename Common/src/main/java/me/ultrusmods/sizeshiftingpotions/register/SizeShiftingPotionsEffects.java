package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import me.ultrusmods.sizeshiftingpotions.CustomScaleTypes;
import me.ultrusmods.sizeshiftingpotions.effects.DividingSizeStatusEffect;
import me.ultrusmods.sizeshiftingpotions.effects.MultiplyingSizeStatusEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class SizeShiftingPotionsEffects {
    public static final RegistrationProvider<MobEffect> EFFECTS = RegistrationProvider.get(Registries.MOB_EFFECT, Constants.MOD_ID);
    public static final RegistryObject<MobEffect> GROWING = EFFECTS.register("growing", () -> new MultiplyingSizeStatusEffect(MobEffectCategory.NEUTRAL, 0xda086a, CustomScaleTypes.SIZE));
    public static final RegistryObject<MobEffect> SHRINKING = EFFECTS.register("shrinking", () -> new DividingSizeStatusEffect(MobEffectCategory.NEUTRAL, 0xcca468, CustomScaleTypes.SIZE));
    public static final RegistryObject<MobEffect> WIDENING = EFFECTS.register("widening", () -> new MultiplyingSizeStatusEffect(MobEffectCategory.NEUTRAL, 0xb3ffc2, CustomScaleTypes.THICKNESS));
    public static final RegistryObject<MobEffect> THINNING = EFFECTS.register("thinning", () -> new DividingSizeStatusEffect(MobEffectCategory.NEUTRAL, 0xe3b3ff, CustomScaleTypes.THICKNESS));

    public static void init() {

    }
}
