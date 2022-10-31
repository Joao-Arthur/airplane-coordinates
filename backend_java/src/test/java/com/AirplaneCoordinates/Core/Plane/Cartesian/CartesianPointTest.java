package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CartesianPointTest {
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
