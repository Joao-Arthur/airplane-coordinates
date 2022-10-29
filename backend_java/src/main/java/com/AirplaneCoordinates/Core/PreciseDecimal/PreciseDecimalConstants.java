package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.MathContext;
import java.math.RoundingMode;

public final class PreciseDecimalConstants {
    public static final int PRECISION = 100;
    public static final int ROUNDING_PRECISION = PRECISION -6;
    public static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_EVEN);
    public static final MathContext ROUNDING_MATH_CONTEXT = new MathContext(ROUNDING_PRECISION, RoundingMode.HALF_EVEN);
}
