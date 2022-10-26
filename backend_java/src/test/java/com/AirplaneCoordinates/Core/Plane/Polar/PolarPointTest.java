package com.AirplaneCoordinates.Core.Plane.Polar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public class PolarPointTest {
    @Test
    public final void rotate() {
        assertEquals(
            PolarPoint.from(1, 300).rotate(PreciseDecimal.from(50)).value,
            PolarPoint.from(1, 350).value
        );
        assertEquals(
            PolarPoint.from(1, 200).rotate(PreciseDecimal.from(50)).value,
            PolarPoint.from(1, 250).value
        );
        assertEquals(
            PolarPoint.from(1, "111.11").rotate(PreciseDecimal.from("11.40")).value,
            PolarPoint.from(1, "122.51").value
        );
        assertEquals(
            PolarPoint.from(1, 342).rotate(PreciseDecimal.from(194)).value,
            PolarPoint.from(1, 176).value
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-120)).value,
            PolarPoint.from(1, 300).value
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-60)).value,
            PolarPoint.from(1, 0).value
        );
    }
}
