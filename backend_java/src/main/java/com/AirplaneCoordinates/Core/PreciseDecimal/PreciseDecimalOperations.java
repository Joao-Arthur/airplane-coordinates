package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;

import ch.obermuhlner.math.big.BigDecimalMath;

public final class PreciseDecimalOperations {
    public static final PreciseDecimal sum(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);

        return new PreciseDecimal(
            PreciseDecimalHelper.bigDecimalToString(
                aValue.add(bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }
    
    public static final PreciseDecimal sub(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);

        return new PreciseDecimal(
            PreciseDecimalHelper.bigDecimalToString(
                aValue.subtract(bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public static final PreciseDecimal mul(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);

        return new PreciseDecimal(
            PreciseDecimalHelper.bigDecimalToString(
                aValue.multiply(bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public static final PreciseDecimal div(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);

        return new PreciseDecimal(
            PreciseDecimalHelper.bigDecimalToString(
                aValue.divide(bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public static final PreciseDecimal rem(final PreciseDecimal a, final PreciseDecimal b) {
        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);

        return new PreciseDecimal(
            PreciseDecimalHelper.bigDecimalToString(
                aValue.remainder(bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public static final PreciseDecimal atan(final PreciseDecimal a, final PreciseDecimal b) {
        if (
            a.equals(PreciseDecimal.from(0)) &&
            b.equals(PreciseDecimal.from(0))
        )
            return PreciseDecimal.from(0);

        final var aValue = new BigDecimal(a.value, PreciseDecimalConstants.MATH_CONTEXT);
        final var bValue = new BigDecimal(b.value, PreciseDecimalConstants.MATH_CONTEXT);
        
        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                BigDecimalMath.atan2(aValue, bValue, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }
}
