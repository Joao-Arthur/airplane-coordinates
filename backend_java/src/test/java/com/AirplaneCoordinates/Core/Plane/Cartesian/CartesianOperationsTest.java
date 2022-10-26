package com.AirplaneCoordinates.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

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
    
    @Test
    public final void distance() {
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(0, 0)
            ),
            PreciseDecimal.from(0)
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(1, 1),
                CartesianPoint.from(1, 1)
            ),
            PreciseDecimal.from(0)
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(-10, 5),
                CartesianPoint.from(20, 5)
            ),
            PreciseDecimal.from("30.0")
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ),
            PreciseDecimal.from("30.0")
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(5, 10),
                CartesianPoint.from(5, -20)
            ),
            PreciseDecimal.from("30.0")
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(0, 0),
                CartesianPoint.from(1, 1)
            ),
            PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573")
        );
        assertEquals(
            CartesianOperations.distance(
                CartesianPoint.from(-1,-1),
                CartesianPoint.from(1,1)
            ),
            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145")
        );
    }
}