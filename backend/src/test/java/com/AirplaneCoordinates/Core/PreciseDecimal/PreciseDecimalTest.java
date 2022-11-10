package com.AirplaneCoordinates.Core.PreciseDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PreciseDecimalTest {
    @Test
    public final void from() {
        assertEquals(
            new PreciseDecimal("28.37185"),
            PreciseDecimal.from("28.37185")
        );
        assertEquals(
            new PreciseDecimal("-1046.438682"), 
            PreciseDecimal.from("-1046.438682")
        );
        assertEquals(
            new PreciseDecimal("983"),
            PreciseDecimal.from(983)
        );
        assertEquals(
            new PreciseDecimal("-4"),
            PreciseDecimal.from(-4)
        );
    }

    @Test
    public final void format() {
        assertEquals(
            PreciseDecimal.from("1.38").format(),
            "+1.38"
        );
        assertEquals(
            PreciseDecimal.from("-0.6").format(),
            "-0.6"
        );
        assertEquals(
            PreciseDecimal.from("0.0000000000000000000000000000").format(),
            "0"
        );
    }

    @Test
    public final void toStringTest() {
        assertEquals(
            PreciseDecimal.from("3.8909").toString(),
            "3.8909"
        );
    }
}