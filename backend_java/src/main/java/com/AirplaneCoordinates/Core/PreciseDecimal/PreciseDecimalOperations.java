package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import ch.obermuhlner.math.big.BigDecimalMath;

public final class PreciseDecimalOperations {
    private static final int PRECISION = 100;
    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_EVEN);

    public static final PreciseDecimal sum(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.add(bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString()
        );
    }
    
    public static final PreciseDecimal sub(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.subtract(bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString()
        );
    }

    public static final PreciseDecimal mul(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.multiply(bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString()
        );
    }

    public static final PreciseDecimal div(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.divide(bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString()
        );
    }

    public static final PreciseDecimal rem(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.remainder(bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString()
        );
    }

    public static final PreciseDecimal atan(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);
        
        return PreciseDecimal.from(BigDecimalMath.atan2(aValue, bValue, MATH_CONTEXT).stripTrailingZeros().toPlainString());
    }
}
