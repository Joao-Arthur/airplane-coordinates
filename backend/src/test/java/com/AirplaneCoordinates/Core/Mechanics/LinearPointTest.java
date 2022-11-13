package com.AirplaneCoordinates.Core.Mechanics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class LinearPointTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            LinearPoint.from("-42.1", "+2.202").toString(),
            "(-42.1 km, +2.202 km/h)"
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 2, 10, 1, 10, 20",
        "-5, 1, 5, -1, 5, 0",
        "2, 0, -8, 1, 10, 2",
        "2, 0, 8, -1, 6, 2"
    })
    public final void collisionPoint(
        final String aInitialPoint,
        final String aSpeed,
        final String bInitialPoint,
        final String bSpeed,
        final String x,
        final String y
    ) {
        assertEquals(
            LinearPoint.collisionPoint(
                LinearPoint.from(aInitialPoint, aSpeed),
                LinearPoint.from(bInitialPoint, bSpeed)
            ).toString(),
            CartesianPoint.from(x, y).toString()
        );
    }

    @Test
    public final void collisionPointEdgeCases() {
        assertEquals(
            LinearPoint.collisionPoint(
                LinearPoint.from(500, -3),
                LinearPoint.from(-500, 3)
            ).toString(),
            CartesianPoint.from(
                "166.6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666667",
                "-0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"
            ).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 10, 100, 10",
        "0, 2, 100, 50",
        "0, 2, 0, 0",
        "0, 2, -100, -50",
        "0, 0.5, 5, 10",
    })
    public final void timeTo(
        final String initialPoint,
        final String speed,
        final String point,
        final String time
    ) {
        assertEquals(
            LinearPoint.from(
                initialPoint,
                speed
            ).timeTo(
                PreciseDecimal.from(point)
            ).toString(),
            PreciseDecimal.from(time).toString()
        );
    }
}
