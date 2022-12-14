package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class SamePositionCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 5),
                    Vector.from(186, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 5),
                    Vector.from(17, 9)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(0),
                CartesianPoint.from(2, 5),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 4, 7),
                    Vector.from(186, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 7),
                    Vector.from(17, 9)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(0),
                CartesianPoint.from(4, 7),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.POLAR, 1, 180),
                    Vector.from(186, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -1, 0),
                    Vector.from(17, 9)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(0),
                CartesianPoint.from(-1, 0),
                PreciseDecimal.from(0)
            ).toString()
        );
    }
}
