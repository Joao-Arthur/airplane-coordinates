package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.MathContext;
import java.math.RoundingMode;

public class PreciseDecimalConstants {
    public static final int PRECISION = 100;
    public static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_EVEN);
}
