package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalAggregationsTest {
    @Test
    public final void min() {
        assertEquals(
            PreciseDecimal.min(
                PreciseDecimal.from(10),
                PreciseDecimal.from("10.1")
            ).toString(),
            PreciseDecimal.from(10).toString()
        );
    }

    @Test
    public final void max() {
        assertEquals(
            PreciseDecimal.max(
                PreciseDecimal.from(10),
                PreciseDecimal.from("10.1")
            ).toString(),
            PreciseDecimal.from("10.1").toString()
        );
    }
}
