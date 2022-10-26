package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class PreciseDecimalOperations {
    private static final int PRECISION = 100;
    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION);

    public static final PreciseDecimal sum(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.add(bValue).toString()
        );
    }
    
    public static final PreciseDecimal sub(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.subtract(bValue).toString()
        );
    }

    public static final PreciseDecimal mul(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.multiply(bValue).toString()
        );
    }

    public static final PreciseDecimal div(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.divide(bValue, RoundingMode.HALF_EVEN).toString()
        );
    }

    public static final PreciseDecimal rem(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, MATH_CONTEXT);

        return new PreciseDecimal(
            aValue.remainder(bValue).toString()
        );
    }
}
