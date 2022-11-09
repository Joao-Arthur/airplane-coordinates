package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class Rad {
    public final PreciseDecimal value; 

    private Rad(final PreciseDecimal value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return this.value.value;
    }

    public static final Rad from(final PreciseDecimal value) {
        return new Rad(value);
    }

    public final Deg toDeg() {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = PreciseDecimalOperations.mul(this.value, halfCircle);
        final var val2 = PreciseDecimalOperations.div(val1, pi);

        return Deg.from(val2);
    }   
}
