package me.ultrusmods.sizeshiftingpoitons;

import eu.midnightdust.lib.config.MidnightConfig;
import me.ultrusmods.sizeshiftingpoitons.config.SizeShiftingPotionsConfigForge;
import me.ultrusmods.sizeshiftingpotions.SizeShiftingPotionsCommon;
import me.ultrusmods.sizeshiftingpotions.Constants;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SizeShiftingPotionsForge {
    
    public SizeShiftingPotionsForge() {
        MidnightConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfigForge.class);
        SizeShiftingPotionsCommon.init();
    }

}