package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class Degree {
    public final PreciseDecimal value; 

    private Degree(final PreciseDecimal value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return this.value.value;
    }

    public static Degree from(final PreciseDecimal value) {
        return new Degree(value);
    }
    
    public final PreciseDecimal normalize() {
        final var fullCircle = PreciseDecimal.from(360);

        final var val1 = PreciseDecimalOperations.rem(this.value, fullCircle);
        final var val2 = PreciseDecimalOperations.sum(val1, fullCircle);
        final var val3 = PreciseDecimalOperations.rem(val2, fullCircle);
        
        return val3;
    }

    public final boolean isInfiniteTangent() {
        return (
            PreciseDecimal.from(90).equals(this.normalize()) ||
            PreciseDecimal.from(270).equals(this.normalize())
        );
    }

    public final Radian toRad() {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = PreciseDecimalOperations.mul(this.normalize(), pi);
        final var val2 = PreciseDecimalOperations.div(val1, halfCircle);

        return Radian.from(val2);
    }
}
