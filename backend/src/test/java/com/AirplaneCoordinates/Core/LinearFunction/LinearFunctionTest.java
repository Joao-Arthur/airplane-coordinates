package com.AirplaneCoordinates.Core.LinearFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertEquals(
            LinearFunction.from(
                PreciseDecimal.from("2"),
                PreciseDecimal.from("-1.11")
            ).toString(),
            "y = +2x -1.11"
        );

        assertEquals(
            LinearFunction.from(
                PreciseDecimal.from("0"),
                PreciseDecimal.from("0")
            ).toString(),
            "y = 0x +0"
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 45, 1,0",
        "0, 0, 45, 1,0",
        "-1, -1, 45, 1,0",
        "-1, 1, 135, -1,0",
        "0, 0, 135, -1,0",
        "1, -1, 135, -1,0",
        "-1, 1, 0, 0, 1",
        "0, 0, 0, 0, 0",
        "1, -1, 0, 0, -1",
        "2, 0, 45, 1, -2",
        "2, 4, 45, 1, 2",
    })
    public final void from(
        final int x,
        final int y,
        final int deg,
        final int a,
        final int b
    ) {
        assertEquals(
            LinearFunction.from(
                CartesianPoint.from(x, y),
                PreciseDecimal.from(deg)
            ).toString(),
            LinearFunction.from(a, b).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, -2, 2",
        "1, -1, 1",
        "1, 0, 0",
        "1, 1, -1",
        "1, 2, -2",
        "2, -2, 1",
        "2, -1, 0.5",
        "2, 0, 0",
        "2, 1, -0.5",
        "2, 2, -1",
        "0.5, -2, 4",
        "0.5, -1, 2",
        "0.5, 0, 0",
        "0.5, 1, -2",
        "0.5, 2, -4",
        "-0.25, -2, -8",
        "-0.25, -1, -4",
        "-0.25, 0, 0",
        "-0.25, 1, 4",
        "-0.25, 2, 8",
    })
    public final void root(
        final String a,
        final String b,
        final String x
    ) {
        assertEquals(
            LinearFunction.from(a, b).root().toString(),
            PreciseDecimal.from(x).toString()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, -1, -1, -2",
        "1, -1, 0, -1",
        "1, -1, 1, 0",
        "1, 0, -1, -1",
        "1, 0, 0, 0",
        "1, 0, 1, 1",
        "1, 1, -1, 0",
        "1, 1, 0, 1",
        "1, 1, 1, 2",
        "1, 1, -1, 0",
        "1, 1, 0, 1",
        "1, 1, 1, 2",
        "2, -1, -1, -3",
        "2, -1, 0, -1",
        "2, -1, 1, 1",
        "2, 0, -1, -2",
        "2, 0, 0, 0",
        "2, 0, 1, 2",
        "2, 1, -1, -1",
        "2, 1, 0, 1",
        "2, 1, 1, 3",
    })
    public final void execute(
        final int a,
        final int b,
        final int x,
        final int y
    ) {
        assertEquals(
            LinearFunction.from(a, b)
                .execute(PreciseDecimal.from(x))
                .toString(),
            PreciseDecimal.from(y).toString()
        );
    }
}
