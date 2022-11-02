package com.AirplaneCoordinates.Core.Plane.Polar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PolarPointTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            PolarPoint.from(4, 0).toString(),
            "(4, 0)"
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0, 0",
        "1, 0, 1, 0",
        "1, 90, 0, 1",
        "1, 180, -1, 0",
        "1, 270, 0, -1",
        "1, 360, 1, 0",
    })
    public final void polarToCartesianSimpleAngles(
        final int r,
        final int a,
        final int x,
        final int y
    ) {
        assertEquals(
            PolarPoint.from(r, a).toCartesian().toString(),
            CartesianPoint.from(x, y).toString()
        );
    }

    @Test
    public final void toCartesian() {
        assertEquals(
            PolarPoint.from(1, 45).toCartesian().toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toString()
        );
        assertEquals(
            PolarPoint.from(1, 135).toCartesian().toString(),
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toString()
        );
        assertEquals(
            PolarPoint.from(1, 225).toCartesian().toString(),
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toString()
        );
        assertEquals(
            PolarPoint.from(1, 315).toCartesian().toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
            ).toString()
        );
        assertEquals(
            PolarPoint.from(1, 405).toCartesian().toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toString()
        );
    }

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
