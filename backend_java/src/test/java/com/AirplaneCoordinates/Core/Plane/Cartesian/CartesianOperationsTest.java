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
            ),
            CartesianPoint.from(6, 4)
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(-1, 3),
                CartesianPoint.from(2, -3)
            ),
            CartesianPoint.from(1, 0)
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(0, 0)
            ),
            CartesianPoint.from(4, 7)
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(6, 4),
                CartesianPoint.from(-4, -7)
            ),
            CartesianPoint.from(2, -3)
        );
    }

    @Test
    public final void sub() {
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(6, 3),
                CartesianPoint.from(4, 7)
            ),
            CartesianPoint.from(2, -4)
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(1, 0),
                CartesianPoint.from(-1, 3)
            ),
            CartesianPoint.from(2, -3)
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(4, 7)
            ),
            CartesianPoint.from(0, 0)
        );
    }

    @Test
    public final void mul() {
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ),
            CartesianPoint.from(8, -21)
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1, 3),
                 CartesianPoint.from(2, -3)
            ),
            CartesianPoint.from(-2, -9)
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1,3),
                CartesianPoint.from(0, 0)
            ),
            CartesianPoint.from(0, 0)
        );
    }

    @Test
    public final void div() {
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(8, -21),
                CartesianPoint.from(4, 7)
            ),
            CartesianPoint.from(2, -3)
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(-2, -9),
                CartesianPoint.from(-1, 3)
            ),
            CartesianPoint.from(2, -3)
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(-1,3)
            ),
            CartesianPoint.from(0, 0)
        );
    }
}