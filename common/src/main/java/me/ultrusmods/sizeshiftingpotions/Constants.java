package me.ultrusmods.sizeshiftingpotions;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
	public static final String MOD_ID = "sizeshiftingpotions";
	public static final String MOD_NAME = "SizeShiftingPotions";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}
}