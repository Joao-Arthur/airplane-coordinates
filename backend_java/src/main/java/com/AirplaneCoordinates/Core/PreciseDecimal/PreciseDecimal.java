package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;

import ch.obermuhlner.math.big.BigDecimalMath;

public final class PreciseDecimal {
    public final String value;

    public PreciseDecimal(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof PreciseDecimal))
            return false;
        PreciseDecimal other = (PreciseDecimal) object;
        return this.value.equals(other.value);
    }

    public static final PreciseDecimal from(final String value) {
        return new PreciseDecimal(value);
    }

    public static final PreciseDecimal from(final int value) {
        return new PreciseDecimal(String.valueOf(value));
    }

    public static final PreciseDecimal pi() {
        return PreciseDecimal.from(BigDecimalMath.pi(PreciseDecimalConstants.MATH_CONTEXT).toString());
    }

    public final PreciseDecimal opposite() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                valueAsBigDecimal.negate(PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public final PreciseDecimal reverse() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                BigDecimal.ONE.divide(valueAsBigDecimal, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public final PreciseDecimal square() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                valueAsBigDecimal.multiply(valueAsBigDecimal, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public final PreciseDecimal sqrt() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                BigDecimalMath.sqrt(valueAsBigDecimal, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public final PreciseDecimal sin() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                BigDecimalMath.sin(valueAsBigDecimal, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }

    public final PreciseDecimal cos() {
        final var valueAsBigDecimal = new BigDecimal(this.value, PreciseDecimalConstants.MATH_CONTEXT);

        return PreciseDecimal.from(
            PreciseDecimalHelper.bigDecimalToString(
                BigDecimalMath.cos(valueAsBigDecimal, PreciseDecimalConstants.MATH_CONTEXT)
            )
        );
    }
}
