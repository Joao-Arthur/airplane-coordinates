package com.AirplaneCoordinates.Core.Plane.Polar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PolarPointTest {
    @Test
    public final void rotate() {
        assertEquals(
            PolarPoint.from(1, 300).rotate(PreciseDecimal.from(50)).toString(),
            PolarPoint.from(1, 350).toString()
        );
        assertEquals(
            PolarPoint.from(1, 200).rotate(PreciseDecimal.from(50)).toString(),
            PolarPoint.from(1, 250).toString()
        );
        assertEquals(
            PolarPoint.from(1, "111.11").rotate(PreciseDecimal.from("11.40")).toString(),
            PolarPoint.from(1, "122.51").toString()
        );
        assertEquals(
            PolarPoint.from(1, 342).rotate(PreciseDecimal.from(194)).toString(),
            PolarPoint.from(1, 176).toString()
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-120)).toString(),
            PolarPoint.from(1, 300).toString()
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-60)).toString(),
            PolarPoint.from(1, 0).toString()
        );
    }

    @Test
    public final void round() {
        assertEquals(
            PolarPoint.from(
                "3.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000026",
                "359.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999986"
            ).round().toString(),
            PolarPoint.from(3, 0).toString()
        );
    }
}
