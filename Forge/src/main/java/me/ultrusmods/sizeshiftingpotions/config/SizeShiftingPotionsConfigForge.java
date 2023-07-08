package me.ultrusmods.sizeshiftingpotions.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class SizeShiftingPotionsConfigForge extends MidnightConfig {
    @Entry(min = 10d, max = 64d)
    public static double maxSize = 10d;
    @Entry(min = 0.01d, max = .1d)
    public static double minSize = .1d;

    @Entry(min = 1d, max = 3d)
    public static double sizeChangeFactor = 2d;

    @Comment public static Comment requireRestart;
    @Entry public static boolean growingPotion = true;
    @Entry public static boolean shrinkingPotion = true;

    @Entry public static boolean wideningPotion = true;
    @Entry public static boolean thinningPotion = true;

    @Comment public static Comment netherFungus;
    @Entry public static boolean useNetherFungus = false;
}
