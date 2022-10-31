package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;

public class CartesianPointTest {
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0, 0",
        "1, 0, 1, 0",
        "0, 1, 1, 90",
        "-1, 0, 1, 180",
        "0, -1, 1, 270",
        "1, 0, 1, 0",
    })
    public final void cartesianToPolarSimpleAngles(
        final int x,
        final int y,
        final int r,
        final int a
    ) {
        assertEquals(
            CartesianPoint.from(x, y).toPolar().toString(),
            PolarPoint.from(r, a).toString()
        );
    }

    @Test
    public final void cartesianToPolar() {
        assertEquals(
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toPolar().toString(),
            PolarPoint.from(1, 45).toString()
        );
        assertEquals(
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toPolar().toString(),
           PolarPoint.from(1, 135).toString()
        );
        assertEquals(
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toPolar().toString(),
            PolarPoint.from(1, 225).toString()
        );
        assertEquals(
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
            ).toPolar().toString(),
            PolarPoint.from(1, 315).toString()
        );
        assertEquals(
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toPolar().toString(),
            PolarPoint.from(1, 45).toString()
        );
    }

    @Test
    public final void opposite() {
        assertEquals(
            CartesianPoint.from(-3, 2).opposite().toString(),
            CartesianPoint.from(3, -2).toString()
        );
    }

    @Test
    public final void reverse() {
        assertEquals(
            CartesianPoint.from(2, 4).reverse().toString(),
            CartesianPoint.from("0.5", "0.25").toString()
        );
    }

    @Test
    public final void round() {
        assertEquals(
            CartesianPoint.from(
                "2.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997",
                "4.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000026"
            ).round().toString(),
            CartesianPoint.from(3, 4).toString()
        );
    }
}
