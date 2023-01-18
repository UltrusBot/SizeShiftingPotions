package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

// Gotta stick with my name convention, even if it leads to this.
public class SizeShiftingPotionsPotions {
    public static final RegistrationProvider<Potion> POTIONS = RegistrationProvider.get(Registries.POTION, Constants.MOD_ID);

    public static RegistryObject<Potion> GROWING_POTION = register("growing", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING.get(), 3600)));
    public static RegistryObject<Potion> LONG_GROWING_POTION = register("growing_long", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING.get(), 9600)));
    public static RegistryObject<Potion> STRONG_GROWING_POTION = register("growing_strong", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING.get(), 1800, 1)));

    public static RegistryObject<Potion> SHRINKING_POTION = register("shrinking", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING.get(), 3600)));
    public static RegistryObject<Potion> LONG_SHRINKING_POTION = register("shrinking_long", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING.get(), 9600)));
    public static RegistryObject<Potion> STRONG_SHRINKING_POTION = register("shrinking_strong", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING.get(), 1800, 1)));

    public static RegistryObject<Potion> WIDENING_POTION = register("widening", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING.get(), 3600)));
    public static RegistryObject<Potion> LONG_WIDENING_POTION = register("widening_long", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING.get(), 9600)));
    public static RegistryObject<Potion> STRONG_WIDENING_POTION = register("widening_strong", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING.get(), 1800, 1)));

    public static RegistryObject<Potion> THINNING_POTION = register("thinning", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING.get(), 3600)));
    public static RegistryObject<Potion> LONG_THINNING_POTION = register("thinning_long", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING.get(), 9600)));
    public static RegistryObject<Potion> STRONG_THINNING_POTION = register("thinning_strong", () -> new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING.get(), 1800, 1)));

    public static void init() {

    }

    private static RegistryObject<Potion> register(String id, Supplier<? extends Potion> supplier) {
        return POTIONS.register(id, supplier);
    }
}
