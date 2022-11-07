package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public class GetCollisionTypeTest {
    @Test
    public final void getCollisionTypeSamePoint() {
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
    }

    @Test
    public final void getCollisionTypeSameFunction() {
        assertEquals(
            new GetCollisionType(
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
                    PlanePoint.from(Plane.CARTESIAN, 4, 2),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "0.5"
                    )
                )
            ).getCollisionType(),
            CollisionType.SAME_FUNCTION
        );
        assertEquals(
            new GetCollisionType(
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
                    PlanePoint.from(Plane.CARTESIAN, 3, 4),
                    Vector.from(
                        "206.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "7"
                    )
                )
            ).getCollisionType(),
            CollisionType.SAME_FUNCTION
        );
    }

    @Test
    public final void getCollisionTypeDifferentFunction() {
        assertEquals(
            new GetCollisionType(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 5, 2),
                    Vector.from(10, 2)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 8, 10),
                    Vector.from(300, 3)
                )
            ).getCollisionType(),
            CollisionType.DIFFERENT_FUNCTIONS
        );
        assertEquals(
            new GetCollisionType(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 8),
                    Vector.from(200, 3)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 5, -7),
                    Vector.from(52, 8)
                )
            ).getCollisionType(),
            CollisionType.DIFFERENT_FUNCTIONS
        );
    }
}
