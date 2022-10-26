package com.AirplaneCoordinates.Core.Plane.Polar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public class PolarTest {
    @Test
    public final void rotate() {
        assertEquals(
            PolarPoint.from(1, 300).rotate(PreciseDecimal.from(50)),
            PolarPoint.from(1, 350)
        );
        assertEquals(
            PolarPoint.from(1, 200).rotate(PreciseDecimal.from(50)),
            PolarPoint.from(1, 250)
        );
        assertEquals(
            PolarPoint.from(1, "111.11").rotate(PreciseDecimal.from("11.40")),
            PolarPoint.from(1, "122.51")
        );
        assertEquals(
            PolarPoint.from(1, 342).rotate(PreciseDecimal.from(194)),
            PolarPoint.from(1, 176)
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-120)),
            PolarPoint.from(1, 300)
        );
        assertEquals(
            PolarPoint.from(1, 60).rotate(PreciseDecimal.from(-60)),
            PolarPoint.from(1, 0)
        );
    }
}
