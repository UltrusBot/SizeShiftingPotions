package me.ultrusmods.sizeshiftingpotions;

import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;

public class SizeShiftingPotionsCommon {

    public static void init() {
        CustomScaleTypes.init();
        SizeShiftingPotionsEffects.init();
        SizeShiftingPotionsPotions.init();
    }
}