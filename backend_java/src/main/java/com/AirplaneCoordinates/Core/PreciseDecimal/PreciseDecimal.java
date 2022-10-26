package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;
import java.math.MathContext;

import ch.obermuhlner.math.big.BigDecimalMath;

public final class PreciseDecimal {
    private static final int PRECISION = 100;
    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION);

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
        return PreciseDecimal.from(BigDecimalMath.pi(MATH_CONTEXT).toString());
    }
    
    public final PreciseDecimal square() {
        final var valueAsBigDecimal = new BigDecimal(this.value, MATH_CONTEXT);

        return PreciseDecimal.from(valueAsBigDecimal.multiply(valueAsBigDecimal, MATH_CONTEXT).stripTrailingZeros().toPlainString());
    }

    public final PreciseDecimal sqrt() {
        final var valueAsBigDecimal = new BigDecimal(this.value, MATH_CONTEXT);

        return PreciseDecimal.from(BigDecimalMath.sqrt(valueAsBigDecimal, MATH_CONTEXT).stripTrailingZeros().toPlainString());
    }

    public final PreciseDecimal sin() {
        final var valueAsBigDecimal = new BigDecimal(this.value, MATH_CONTEXT);

        return PreciseDecimal.from(BigDecimalMath.sin(valueAsBigDecimal, MATH_CONTEXT).stripTrailingZeros().toPlainString());
    }

    public final PreciseDecimal cos() {
        final var valueAsBigDecimal = new BigDecimal(this.value, MATH_CONTEXT);

        return PreciseDecimal.from(BigDecimalMath.cos(valueAsBigDecimal, MATH_CONTEXT).stripTrailingZeros().toPlainString());
    }
}
