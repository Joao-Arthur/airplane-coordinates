package com.AirplaneCoordinates.Core.PreciseDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.AirplaneCoordinates.Core.Mathematics.ComparisionOperations;

import ch.obermuhlner.math.big.BigDecimalMath;

public final class PreciseDecimal implements ComparisionOperations<PreciseDecimal> {
    private static final int PRECISION = 100;
    private static final int ROUNDING_PRECISION = PRECISION -6;
    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_EVEN);
    private static final MathContext ROUNDING_MATH_CONTEXT = new MathContext(ROUNDING_PRECISION, RoundingMode.HALF_EVEN);

    public final String value;
    private final BigDecimal bigDecimalValue;

    public PreciseDecimal(final String value) {
        this.value = value;
        this.bigDecimalValue = new BigDecimal(this.value, PreciseDecimal.MATH_CONTEXT);
    }

    @Override
    public final String toString() {
        return this.value;
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

    private static final PreciseDecimal from(final BigDecimal value) {
        final var plainValue = value.stripTrailingZeros().toPlainString();
        if (!plainValue.contains("."))
            return new PreciseDecimal(plainValue);
        final var arr = plainValue.split("\\.");
        final var integerPart = arr[0];
        final var decimalPart = arr[1];
        if (decimalPart.length() <= PreciseDecimal.PRECISION)
            return new PreciseDecimal(plainValue);
        final var finalValue = integerPart + "." + decimalPart.substring(0, PreciseDecimal.PRECISION);
        return new PreciseDecimal(new BigDecimal(finalValue).stripTrailingZeros().toPlainString());
    }

    private static final String bigDecimalToRoundedString(final BigDecimal value) {
        final var plainValue = value.stripTrailingZeros().toPlainString();
        if (!plainValue.contains("."))
            return plainValue;
        final var arr = plainValue.split("\\.");
        final var integerPart = arr[0];
        final var decimalPart = arr[1];
        if (decimalPart.length() <= PreciseDecimal.ROUNDING_PRECISION)
            return plainValue;
        final var finalValue = integerPart + "." + decimalPart.substring(0, PreciseDecimal.ROUNDING_PRECISION);
        return new BigDecimal(finalValue).stripTrailingZeros().toPlainString();
    }

    public static final PreciseDecimal pi() {
        return PreciseDecimal.from(
            BigDecimalMath.pi(PreciseDecimal.MATH_CONTEXT).toString()
        );
    }

    public static final PreciseDecimal halfPi() {
        final var bigDecimal2 = new BigDecimal(
            2,
            PreciseDecimal.MATH_CONTEXT
        );

        return PreciseDecimal.from(
            BigDecimalMath
                .pi(PreciseDecimal.MATH_CONTEXT)
                .divide(bigDecimal2)
                .toString()
        );
    }

    public static final PreciseDecimal threeQuartsPi() {
        final var bigDecimal2 = new BigDecimal(
            2,
            PreciseDecimal.MATH_CONTEXT
        );
        final var bigDecimal3 = new BigDecimal(
            3,
            PreciseDecimal.MATH_CONTEXT
        );

        return PreciseDecimal.from(
            BigDecimalMath
                .pi(PreciseDecimal.MATH_CONTEXT)
                .divide(bigDecimal2)
                .multiply(bigDecimal3)
                .toString()
        );
    }

    public final PreciseDecimal opposite() {
        return PreciseDecimal.from(
            this.bigDecimalValue.negate(PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal reverse() {
        return PreciseDecimal.from(
            BigDecimal.ONE.divide(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal square() {
        return PreciseDecimal.from(
            this.bigDecimalValue.multiply(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal sqrt() {
        return PreciseDecimal.from(
            BigDecimalMath.sqrt(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal sin() {
        return PreciseDecimal.from(
            BigDecimalMath.sin(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal cos() {
        return PreciseDecimal.from(
            BigDecimalMath.cos(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal tan() {
        return PreciseDecimal.from(
            BigDecimalMath.tan(this.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final PreciseDecimal round() {
        final var roundedValue = PreciseDecimal.bigDecimalToRoundedString(
            BigDecimalMath.round(this.bigDecimalValue, PreciseDecimal.ROUNDING_MATH_CONTEXT)
        );
        // If the rounded value is integer
        if (!roundedValue.contains("."))
            return PreciseDecimal.from(
                roundedValue
            );
        final var oldDecimalPart = this.value.split("\\.")[1];
        final var newDecimalPart = roundedValue.split("\\.")[1];
        // Conpare the old and new number of decimal digits
        if (newDecimalPart.length() + 10 >= oldDecimalPart.length())
            return PreciseDecimal.from(
                this.value
            );
        return PreciseDecimal.from(
            roundedValue
        );
    }

    private final String sign() {
        switch(this.bigDecimalValue.signum()) {
            case 1:
                return "+";
            case 0: 
                return "";
            case -1:
                return "-";
            default:
                throw new RuntimeException("invalid signum");
        }
    }

    public final PreciseDecimal abs() {
        return PreciseDecimal.from(
            this.bigDecimalValue.abs(PreciseDecimal.MATH_CONTEXT)
        );
    }

    public final String format() {
        return this.sign() + this.abs().value;
    }

    public final boolean greaterThan(final PreciseDecimal other) {
        return this.bigDecimalValue.compareTo(other.bigDecimalValue) == 1;
    }

    public final boolean greaterOrEquals(final PreciseDecimal other) {
        return this.bigDecimalValue.compareTo(other.bigDecimalValue) > -1;
    }

    public final boolean smallerThan(final PreciseDecimal other) {
        return this.bigDecimalValue.compareTo(other.bigDecimalValue) == -1;
    }

    public final boolean smallerOrEquals(final PreciseDecimal other) {
        return this.bigDecimalValue.compareTo(other.bigDecimalValue) < 1;
    }

    public static final PreciseDecimal sum(final PreciseDecimal a, final PreciseDecimal b) {
        return PreciseDecimal.from(
            a.bigDecimalValue.add(b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }
    
    public static final PreciseDecimal sub(final PreciseDecimal a, final PreciseDecimal b) {
        return PreciseDecimal.from(
            a.bigDecimalValue.subtract(b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public static final PreciseDecimal mul(final PreciseDecimal a, final PreciseDecimal b) {
        return PreciseDecimal.from(
            a.bigDecimalValue.multiply(b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public static final PreciseDecimal div(final PreciseDecimal a, final PreciseDecimal b) {
        return PreciseDecimal.from(
            a.bigDecimalValue.divide(b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public static final PreciseDecimal rem(final PreciseDecimal a, final PreciseDecimal b) {
        return PreciseDecimal.from(
            a.bigDecimalValue.remainder(b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public static final PreciseDecimal atan(final PreciseDecimal a, final PreciseDecimal b) {
        if (
            a.equals(PreciseDecimal.from(0)) &&
            b.equals(PreciseDecimal.from(0))
        )
            return PreciseDecimal.from(0);
        return PreciseDecimal.from(
            BigDecimalMath.atan2(a.bigDecimalValue, b.bigDecimalValue, PreciseDecimal.MATH_CONTEXT)
        );
    }

    public static final int compareAsc(final PreciseDecimal a, final PreciseDecimal b) {
        if(a.value.equals(b.value))
            return 0;
        if(a.greaterThan(b))
            return 1;
        return -1;
    }

    public static final int compareDesc(final PreciseDecimal a, final PreciseDecimal b) {
        if(a.value.equals(b.value))
            return 0;
        if(a.greaterThan(b))
            return -1;
        return 1;
    }
}
