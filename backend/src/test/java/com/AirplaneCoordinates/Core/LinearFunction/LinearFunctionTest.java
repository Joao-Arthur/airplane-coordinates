package com.AirplaneCoordinates.Core.LinearFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class LinearFunctionTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            LinearFunction.from(
                PreciseDecimal.from("-5"),
                PreciseDecimal.from("7.26")
            ).toString(),
            "y = -5x +7.26"
        );
    }

    @Test
    public final void from() {
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(1, 1),
                PreciseDecimal.from(45)
            ),
            LinearFunction.from(1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(45)
            ),
            LinearFunction.from(1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(-1, -1),
                PreciseDecimal.from(45)
            ),
            LinearFunction.from(1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(-1, 1),
                PreciseDecimal.from(135)
            ),
            LinearFunction.from(-1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(135)
            ),
            LinearFunction.from(-1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(1, -1),
                PreciseDecimal.from(135)
            ),
            LinearFunction.from(-1,0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(-1, 1),
                PreciseDecimal.from(0)
            ),
            LinearFunction.from(0, 1).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(0)
            ),
            LinearFunction.from(0, 0).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(1, -1),
                PreciseDecimal.from(0)
            ),
            LinearFunction.from(0, -1).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(2, 0),
                PreciseDecimal.from(45)
            ),
            LinearFunction.from(1, -2).toString()
        );
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(2, 4),
                PreciseDecimal.from(45)
            ),
            LinearFunction.from(1, 2).toString()
        );
    }
}
