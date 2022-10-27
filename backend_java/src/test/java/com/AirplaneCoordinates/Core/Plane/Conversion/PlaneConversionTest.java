package com.AirplaneCoordinates.Core.Plane.Conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;

public final class PlaneConversionTest {
    @Test
    public final void polarToCartesian() {
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 0)).value,
            CartesianPoint.from(1, 0).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 90)).value,
            CartesianPoint.from(0, 1).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 180)).value,
            CartesianPoint.from(-1, 0).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 270)).value,
            CartesianPoint.from(0, -1).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 360)).value,
            CartesianPoint.from(1, 0).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 45)).value,
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 135)).value,
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 225)).value,
            CartesianPoint.from(
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 315)).value,
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 405)).value,
            CartesianPoint.from(
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(0, 0)).value,
            CartesianPoint.from(0, 0).value
        );
    }

    @Test
    public final void cartesianToPolar() {
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(1, 0)).value,
            PolarPoint.from(1, 0).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(0, 1)).value,
            PolarPoint.from(1, 90).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(-1, 0)).value,
            PolarPoint.from(1, 180).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(0, -1)).value,
            PolarPoint.from(1, 270).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(1, 0)).value,
            PolarPoint.from(1, 0).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
                )
            ).value,
            PolarPoint.from(1, 45).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
                )
            ).value,
           PolarPoint.from(1, 135).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864"
                )
            ).value,
            PolarPoint.from(1, 225).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207864",
                    "-0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207863"
                )
            ).value,
            PolarPoint.from(1, 315).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(
                CartesianPoint.from(
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207862",
                    "0.7071067811865475244008443621048490392848359376884740365883398689953662392310535194251937671638207865"
                )
            ).value,
            PolarPoint.from(1, 45).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(0, 0)).value,
            PolarPoint.from(0, 0).value
        );
    }
}
