package io.github.ultrusbot.sizeshiftingpotions;

import net.minecraft.util.math.MathHelper;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleModifier;

public class PotionScaleModifier extends ScaleModifier {
    static float minScale = 0.1f;
    static float maxScale = 10f;
    float scale;

    public PotionScaleModifier(float scale) {
        super(1024.f);
        this.scale = scale;
    }

    @Override
    public float modifyScale(ScaleData scaleData, float modifiedScale, float delta) {
        return MathHelper.clamp(modifiedScale * scale, minScale, maxScale);
    }
}
