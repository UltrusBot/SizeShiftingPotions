package me.ultrusmods.sizeshiftingpotions.platform;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfigFabric;
import me.ultrusmods.sizeshiftingpotions.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public double getMaxSize() {
        return SizeShiftingPotionsConfigFabric.maxSize;
    }

    @Override
    public double getMinSize() {
        return SizeShiftingPotionsConfigFabric.minSize;
    }

    @Override
    public boolean getGrowingPotion() {
        return SizeShiftingPotionsConfigFabric.growingPotion;
    }

    @Override
    public boolean getShrinkingPotion() {
        return SizeShiftingPotionsConfigFabric.shrinkingPotion;
    }

    @Override
    public boolean getWideningPotion() {
        return SizeShiftingPotionsConfigFabric.wideningPotion;
    }

    @Override
    public boolean getThinningPotion() {
        return SizeShiftingPotionsConfigFabric.thinningPotion;
    }

    @Override
    public boolean getUseNetherFungus() {
        return SizeShiftingPotionsConfigFabric.useNetherFungus;
    }
}
