package me.ultrusmods.sizeshiftingpotions;


import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.*;

public class CustomScaleTypes {


    public static final ScaleModifier SIZE_MODIFIER = registerModifier("size_modifier", new TypedScaleModifier(() -> CustomScaleTypes.SIZE));
    public static final ScaleModifier THICKNESS_MODIFIER = registerModifier("thickness_modifier", new TypedScaleModifier(() -> CustomScaleTypes.THICKNESS));
    public static final ScaleModifier SPEED_MODIFIER = registerModifier("speed_modifier",
            new TypedScaleModifier(() -> CustomScaleTypes.SIZE, CustomScaleTypes::computeSpeedScale));

    private static double computeSpeedScale(double modifiedScale, double scale) {
        double factor = SizeShiftingPotionsConfig.speedChangeFactor;
        double speedScale;
        if (scale >= 1.0) {
            speedScale = (scale - 1.0) * factor + 1.0;
        } else {
            double shrinkFactor = switch (SizeShiftingPotionsConfig.shrinkSpeedMode) {
                case OFF -> 1.0;
                case ON -> factor;
                case NOT_WHEN_ABOVE_ONE -> Math.min(factor, 1.0);
            };
            speedScale = Math.pow(scale, shrinkFactor);
        }
        return modifiedScale * Math.max(0.1, speedScale);
    }

    public static final ScaleType SIZE = registerScale("size", CustomScaleTypes.SIZE_MODIFIER);
    public static final ScaleType THICKNESS = registerScale("thickness", CustomScaleTypes.THICKNESS_MODIFIER);


    private static ScaleType registerScale(String id, ScaleModifier dependantModifier) {
        final ScaleType.Builder builder = ScaleType.Builder.create().affectsDimensions();

        builder.addDependentModifier(ScaleModifiers.REACH_MULTIPLIER);
        builder.addDependentModifier(dependantModifier);

        return ScaleRegistries.register(ScaleRegistries.SCALE_TYPES,
                new Identifier(Constants.MOD_ID, id),
                builder.build());
    }
    public static ScaleModifier registerModifier(String id, ScaleModifier modifier) {
        return ScaleRegistries.register(ScaleRegistries.SCALE_MODIFIERS, new Identifier(Constants.MOD_ID, id), modifier);
    }

    public static void init() {
        ScaleTypes.HEIGHT.getDefaultBaseValueModifiers().add(SIZE_MODIFIER);
        ScaleTypes.WIDTH.getDefaultBaseValueModifiers().add(SIZE_MODIFIER);
        ScaleTypes.VISIBILITY.getDefaultBaseValueModifiers().add(SIZE_MODIFIER);
        ScaleTypes.MOTION.getDefaultBaseValueModifiers().add(SPEED_MODIFIER);

        if (SizeShiftingPotionsConfig.addReachModifier) {
            ScaleTypes.REACH.getDefaultBaseValueModifiers().add(SIZE_MODIFIER);
        }

        ScaleTypes.WIDTH.getDefaultBaseValueModifiers().add(THICKNESS_MODIFIER);
    }
}