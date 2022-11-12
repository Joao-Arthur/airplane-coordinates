package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class InfiniteTangentInOnePointCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        /*assertEquals(
            new InfiniteTangentInOnePointCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -3, 5),
                    Vector.from(270, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, -3),
                    Vector.from(153, 4)
                ))
            ).getCollisionPoint(),
            null
        );
        assertEquals(
            new InfiniteTangentInOnePointCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 1, 2),
                    Vector.from(76, 5)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 4),
                    Vector.from(90, 6)
                ))
            ).getCollisionPoint(),
            null
        );*/
    }
}
