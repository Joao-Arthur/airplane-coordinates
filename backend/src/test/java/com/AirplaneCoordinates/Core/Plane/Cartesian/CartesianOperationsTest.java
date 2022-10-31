package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianOperationsTest {
    @Test
    public final void sum() {
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(6, 4).toString()
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(-1, 3),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(1, 0).toString()
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(0, 0)
            ).toString(),
            CartesianPoint.from(4, 7).toString()
        );
        assertEquals(
            CartesianOperations.sum(
                CartesianPoint.from(6, 4),
                CartesianPoint.from(-4, -7)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
    }

    @Test
    public final void sub() {
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(6, 3),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(2, -4).toString()
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(1, 0),
                CartesianPoint.from(-1, 3)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianOperations.sub(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }

    @Test
    public final void mul() {
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(4, 7),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(8, -21).toString()
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1, 3),
                CartesianPoint.from(2, -3)
            ).toString(),
            CartesianPoint.from(-2, -9).toString()
        );
        assertEquals(
            CartesianOperations.mul(
                CartesianPoint.from(-1,3),
                CartesianPoint.from(0, 0)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }

    @Test
    public final void div() {
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(8, -21),
                CartesianPoint.from(4, 7)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(-2, -9),
                CartesianPoint.from(-1, 3)
            ).toString(),
            CartesianPoint.from(2, -3).toString()
        );
        assertEquals(
            CartesianOperations.div(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(-1,3)
            ).toString(),
            CartesianPoint.from(0, 0).toString()
        );
    }
    
    @Test
    public final void distance() {
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(0, 0)
            ).toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(1, 1),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from(0).toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(-10, 5),
                CartesianPoint.from(20, 5)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ).toString(),
            PreciseDecimal.from("30").toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573").toString()
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(-1, -1),
                CartesianPoint.from(1, 1)
            ).toString(),
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145").toString()
        );
    }
}