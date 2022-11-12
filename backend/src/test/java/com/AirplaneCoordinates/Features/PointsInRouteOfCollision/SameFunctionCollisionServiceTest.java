package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class SameFunctionCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        assertEquals(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 1),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "4"
                    )
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 2),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "0.5"
                    )
                ))
            ).getCollisionPoint(),
            null
        );
        assertEquals(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 1, 3),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "1"
                    )
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 3, 4),
                    Vector.from(
                        "206.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "7"
                    )
                ))
            ).getCollisionPoint(),
            null
        );
    }
}
