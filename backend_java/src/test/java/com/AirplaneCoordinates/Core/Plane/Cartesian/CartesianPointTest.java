package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CartesianPointTest {
    @Test
    public final void opposite() {
        assertEquals(
            CartesianPoint.from(-3, 2).opposite().value,
            CartesianPoint.from(3, -2).value
        );
    }

    @Test
    public final void reverse() {
        assertEquals(
            CartesianPoint.from(2, 4).reverse().value,
            CartesianPoint.from("0.5", "0.25").value
        );
    }

    @Test
    public final void round() {
        assertEquals(
            CartesianPoint.from(
                "2.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997",
                "4.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000026"
            ).round().value,
            CartesianPoint.from(3, 4).value
        );
    }
}
