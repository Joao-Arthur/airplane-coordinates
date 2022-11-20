package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class ParallelLinesCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 1),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "4"
                    )
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 3),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "0.5"
                    )
                )
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 1, 3),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "1"
                    )
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 3, 5),
                    Vector.from(
                        "206.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "7"
                    )
                )
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(360, 5)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(180, 3)
                )
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(90, 7)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(90, 4)
                )
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(90, 7)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(270, 4)
                )
            ).getCollisionPoint()
        );
    }
}
