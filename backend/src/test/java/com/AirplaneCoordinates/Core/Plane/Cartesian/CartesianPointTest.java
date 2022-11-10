package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianPointTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            CartesianPoint.from(2, 8).toString(),
            "(2, 8)"
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

    @Test
    public final void plus() {
        assertEquals(
            CartesianPoint
                .from(4, 7)
                .plus(CartesianPoint.from(2, -3))
                .toString(),
            CartesianPoint.from(6, 4).toString()
        );
        assertEquals(
            CartesianPoint
                .from(-1, 3)
                .plus(CartesianPoint.from(2, -3))
                .toString(),
            CartesianPoint.from(1, 0).toString()
        );
        assertEquals(
            CartesianPoint
                .from(4, 7)
                .plus(CartesianPoint.from(0, 0))
                .toString(),
            CartesianPoint.from(4, 7).toString()
        );
        assertEquals(
            CartesianPoint
                .from(6, 4)
                .plus(CartesianPoint.from(-4, -7))
                .toString(),
            CartesianPoint.from(2, -3).toString()
        );
    }

    @Test
    public final void sub() {
        assertEquals(
            CartesianPoint.sub(
                CartesianPoint.from(6, 3),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(2, -4).toString()
        );
        assertEquals(
            CartesianPoint.sub(
                CartesianPoint.from(1, 0),
                CartesianPoint.from(-1, 3)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianPoint.sub(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }

    @Test
    public final void mul() {
        assertEquals(
            CartesianPoint.mul(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(8, -21).toString()
        );
        assertEquals(
            CartesianPoint.mul(
                CartesianPoint.from(-1, 3),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(-2, -9).toString()
        );
        assertEquals(
            CartesianPoint.mul(
                CartesianPoint.from(-1,3),
                CartesianPoint.from(0, 0)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }

    @Test
    public final void div() {
        assertEquals(
            CartesianPoint.div(
                CartesianPoint.from(8, -21),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianPoint.div(
                CartesianPoint.from(-2, -9),
                CartesianPoint.from(-1, 3)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianPoint.div(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(-1,3)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }
    
    @Test
    public final void distance() {
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(0, 0)
            ).toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(1, 1),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(-10, 5),
                CartesianPoint.from(20, 5)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").toString()
        );
        assertEquals(
            CartesianPoint.distance(
                CartesianPoint.from(-1, -1),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").toString()
        );
    }
}
