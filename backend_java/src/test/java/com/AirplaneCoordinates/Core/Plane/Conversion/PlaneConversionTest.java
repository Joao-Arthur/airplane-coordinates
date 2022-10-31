package com.AirplaneCoordinates.Core.Plane.Conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;

public final class PlaneConversionTest {
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
            PlaneConversion.polarToCartesian(
                PolarPoint.from(r, a)
            ).toString(),
            CartesianPoint.from(x, y).toString()
        );
    }

    @Test
    public final void polarToCartesian() {
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 45)).toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toString()
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 135)).toString(),
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toString()
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 225)).toString(),
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).toString()
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 315)).toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
            ).toString()
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 405)).toString(),
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).toString()
        );
    }

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
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(x, y)
            ).toString(),
            PolarPoint.from(r, a).toString()
        );
    }

    @Test
    public final void cartesianToPolar() {
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
                )
            ).toString(),
            PolarPoint.from(1, 45).toString()
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
                )
            ).toString(),
           PolarPoint.from(1, 135).toString()
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
                )
            ).toString(),
            PolarPoint.from(1, 225).toString()
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
                )
            ).toString(),
            PolarPoint.from(1, 315).toString()
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
                )
            ).toString(),
            PolarPoint.from(1, 45).toString()
        );
    }
}
