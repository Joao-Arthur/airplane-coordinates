package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
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
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("0.7142857142857142857142857142857142857142857142857142857142857142857142857142857142857142857142857143"),
                CartesianPoint.from("4", "0.571428571428571428571428571428571428571428571428571428571428571428571428571428571428571428571428571"),
                PreciseDecimal.from(0)
            ).toString()
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
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("-0.0833333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333"),
                CartesianPoint.from("-2", "4.583333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333334"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new InfiniteTangentSameXCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 2),
                    Vector.from(90, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, -2),
                    Vector.from(90, 1)
                ))
            ).getCollisionPoint(),
            null
        );
        assertEquals(
            new InfiniteTangentSameXCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 2),
                    Vector.from(90, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, -2),
                    Vector.from(90, 2)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from(4),
                CartesianPoint.from(2, 6),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new InfiniteTangentSameXCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -5, -10),
                    Vector.from(90, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -5, 20),
                    Vector.from(270, 2)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from(10),
                CartesianPoint.from(-5, 0),
                PreciseDecimal.from(0)
            ).toString()
        );
    }
}
