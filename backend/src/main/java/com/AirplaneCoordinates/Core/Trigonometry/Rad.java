package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

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

        final var val1 = this.value.times(halfCircle);
        final var val2 = val1.divide(pi);

        return Deg.from(val2);
    }   
}
