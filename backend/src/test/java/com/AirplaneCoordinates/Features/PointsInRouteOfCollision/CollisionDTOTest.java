package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CollisionDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new CollisionDTO(
                "A",
                "B",
                PreciseDecimal.from("2"),
                CartesianPoint.from(7, -7),
                PreciseDecimal.from("5")
            ).toString(),
            "{ a: A, b: B, timeUntilCollision: 2, collisionPoint: (7, -7), timeDifferenceToPoint: 5 }"
        );
    }
}
