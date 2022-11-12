package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class InfiniteTangentSameXCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        assertEquals(
            new InfiniteTangentSameXCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 4, 2),
                    Vector.from(270, 2)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 7),
                    Vector.from(270, 9)
                ))
            ).getCollisionPoint(),
            null
        );
        assertEquals(
            new InfiniteTangentSameXCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 5),
                    Vector.from(90, 5)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -2, 4),
                    Vector.from(270, 7)
                ))
            ).getCollisionPoint(),
            null
        );
    }
}
