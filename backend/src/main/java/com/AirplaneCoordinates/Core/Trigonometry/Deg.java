package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class Deg {
    public final PreciseDecimal value; 

    private Deg(final PreciseDecimal value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return this.value.value;
    }

    public static final Deg from(final PreciseDecimal value) {
        return new Deg(value);
    }
    
    public final PreciseDecimal normalized() {
        final var fullCircle = PreciseDecimal.from(360);

        final var val1 = this.value.remainder(fullCircle);
        final var val2 = val1.plus(fullCircle);
        final var val3 = val2.remainder(fullCircle);
        
        return val3;
    }

    public final boolean isInfiniteTangent() {
        return (
            PreciseDecimal.from(90).equals(this.normalized()) ||
            PreciseDecimal.from(270).equals(this.normalized())
        );
    }

    public final Rad toRad() {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = this.normalized().times(pi);
        final var val2 = val1.divide(halfCircle);

        return Rad.from(val2);
    }

    public final PreciseDecimal getCosValueInQuadrant(final PreciseDecimal value) {        
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(90)))
            return value;
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(180)))
            return value.opposite();
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(270)))
            return value.opposite();
        return value;
    }

    public final PreciseDecimal getSinValueInQuadrant(final PreciseDecimal value) {        
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(90)))
            return value;
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(180)))
            return value;
        if (this.normalized().smallerOrEquals(PreciseDecimal.from(270)))
            return value.opposite();
        return value.opposite();
    }
}
