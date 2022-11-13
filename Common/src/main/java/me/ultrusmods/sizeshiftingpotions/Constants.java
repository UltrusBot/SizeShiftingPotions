package me.ultrusmods.sizeshiftingpotions;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
	public static final String MOD_ID = "sizeshiftingpotions";
	public static final String MOD_NAME = "SizeShiftingPotions";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	public static ResourceLocation id(String id) {
		return new ResourceLocation(MOD_ID, id);
	}
}