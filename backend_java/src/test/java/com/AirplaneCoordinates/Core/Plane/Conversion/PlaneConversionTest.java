package com.AirplaneCoordinates.Core.Plane.Conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlaneConversionTest {
    @Test
    public final void polarToCartesian() {
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 0)).value,
            CartesianPoint.from(1, 0).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 90)).value,
            CartesianPoint.from(
                "-0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008925923158962873287395684462014298936503822914355030584503253124672887066979806660820263610315112846",
                "1"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 180)).value,
            CartesianPoint.from(
                "-1",
                "-0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001785168730185325876330195087697043801180875908126664775654369943120098476233794486654297087559171119"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 270)).value,
            CartesianPoint.from(
                "0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002677770460680870630367848597990798145006512910656987836884117554320577928487771481205784002962934467",
                "-1"
            ).value
        );
        assertEquals(
            PlaneConversion.polarToCartesian(PolarPoint.from(1, 360)).value,
            CartesianPoint.from(
                "1",
                "0"
            ).value
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
            PolarPoint.from(1, 360).value
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
            PolarPoint.from(1, 405).value
        );
        assertEquals(
            PlaneConversion.cartesianToPolar(CartesianPoint.from(0, 0)).value,
            PolarPoint.from(0, 0).value
        );
    }
}
