package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CartesianOperationsTest {
    @Test
    public final void sum() {
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ).value,
            CartesianPoint.from(6, 4).value
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(-1, 3),
                CartesianPoint.from(2, -3)
            ).value,
            CartesianPoint.from(1, 0).value
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(0, 0)
            ).value,
            CartesianPoint.from(4, 7).value
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(6, 4),
                CartesianPoint.from(-4, -7)
            ).value,
            CartesianPoint.from(2, -3).value
        );
    }

    @Test
    public final void sub() {
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(6, 3),
                CartesianPoint.from(4, 7)
            ).value,
            CartesianPoint.from(2, -4).value
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(1, 0),
                CartesianPoint.from(-1, 3)
            ).value,
            CartesianPoint.from(2, -3).value
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(4, 7)
            ).value,
            CartesianPoint.from(0, 0).value
        );
    }

    @Test
    public final void mul() {
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ).value,
            CartesianPoint.from(8, -21).value
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1, 3),
                 CartesianPoint.from(2, -3)
            ).value,
            CartesianPoint.from(-2, -9).value
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1,3),
                CartesianPoint.from(0, 0)
            ).value,
            CartesianPoint.from(0, 0).value
        );
    }

    @Test
    public final void div() {
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(8, -21),
                CartesianPoint.from(4, 7)
            ).value,
            CartesianPoint.from(2, -3).value
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(-2, -9),
                CartesianPoint.from(-1, 3)
            ).value,
            CartesianPoint.from(2, -3).value
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(-1,3)
            ).value,
            CartesianPoint.from(0, 0).value
        );
    }
}