package me.ultrusmods.sizeshiftingpotions;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SizeShiftingPotionsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        SizeShiftingPotionsCommon.init();
        MidnightConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfig.class);
        SizeShiftingPotionsEffects.register(((identifier, statusEffect) -> Registry.register(Registries.STATUS_EFFECT, identifier, statusEffect)));
        SizeShiftingPotionsPotions.register(((identifier, potion) -> Registry.register(Registries.POTION, identifier, potion)));
    }
}
