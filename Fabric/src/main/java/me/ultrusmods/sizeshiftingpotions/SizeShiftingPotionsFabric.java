package me.ultrusmods.sizeshiftingpotions;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfigFabric;
import net.fabricmc.api.ModInitializer;

public class SizeShiftingPotionsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MidnightConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfigFabric.class);
        SizeShiftingPotionsCommon.init();
    }
}
