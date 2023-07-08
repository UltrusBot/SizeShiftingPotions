package me.ultrusmods.sizeshiftingpotions.platform;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfigForge;
import me.ultrusmods.sizeshiftingpotions.platform.services.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public double getMaxSize() {
        return SizeShiftingPotionsConfigForge.maxSize;
    }

    @Override
    public double getMinSize() {
        return SizeShiftingPotionsConfigForge.minSize;
    }

    @Override
    public double getSizeChangeFactor() {
        return SizeShiftingPotionsConfigForge.sizeChangeFactor;
    }

    @Override
    public boolean getGrowingPotion() {
        return SizeShiftingPotionsConfigForge.growingPotion;
    }

    @Override
    public boolean getShrinkingPotion() {
        return SizeShiftingPotionsConfigForge.shrinkingPotion;
    }

    @Override
    public boolean getWideningPotion() {
        return SizeShiftingPotionsConfigForge.wideningPotion;
    }

    @Override
    public boolean getThinningPotion() {
        return SizeShiftingPotionsConfigForge.thinningPotion;
    }

    @Override
    public boolean getUseNetherFungus() {
        return SizeShiftingPotionsConfigForge.useNetherFungus;
    }
}
