package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class GetCollisionTypeTest {
    @Test
    public final void getCollisionTypeSamePoint() {
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 5),
                    Vector.from(186, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 5),
                    Vector.from(17, 9)
                ))
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 4, 7),
                    Vector.from(186, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 4, 7),
                    Vector.from(17, 9)
                ))
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.POLAR, 1, 180),
                    Vector.from(186, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -1, 0),
                    Vector.from(17, 9)
                ))
            ).getCollisionType(),
            CollisionType.SAME_POSITION
        );
    }

    @Test
    public final void getCollisionTypeSameFunction() {
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.SAME_FUNCTION
        );
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.SAME_FUNCTION
        );
    }

    @Test
    public final void getCollisionTypeDifferentFunction() {
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 5, 2),
                    Vector.from(10, 2)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 8, 10),
                    Vector.from(300, 3)
                ))
            ).getCollisionType(),
            CollisionType.DIFFERENT_FUNCTIONS
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 8),
                    Vector.from(200, 3)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 5, -7),
                    Vector.from(52, 8)
                ))
            ).getCollisionType(),
            CollisionType.DIFFERENT_FUNCTIONS
        );
    }

    @Test
    public final void getCollisionTypeParallelLines() {
        assertEquals(
            new GetCollisionType(
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
                    PlanePoint.from(Plane.CARTESIAN, 4, 3),
                    Vector.from(
                        "26.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "0.5"
                    )
                ))
            ).getCollisionType(),
            CollisionType.PARALLEL_LINES
        );
        assertEquals(
            new GetCollisionType(
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
                    PlanePoint.from(Plane.CARTESIAN, 3, 5),
                    Vector.from(
                        "206.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "7"
                    )
                ))
            ).getCollisionType(),
            CollisionType.PARALLEL_LINES
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(360, 5)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(180, 3)
                ))
            ).getCollisionType(),
            CollisionType.PARALLEL_LINES
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(90, 7)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(90, 4)
                ))
            ).getCollisionType(),
            CollisionType.PARALLEL_LINES
        );
        assertEquals(
            new GetCollisionType(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 2),
                    Vector.from(90, 7)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, -2),
                    Vector.from(270, 4)
                ))
            ).getCollisionType(),
            CollisionType.PARALLEL_LINES
        );
    }

    @Test
    public final void getCollisionTypeInfiniteTangents() {
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.INFINITE_TANGENT_SAME_X
        );
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.INFINITE_TANGENT_SAME_X
        );
    }

    @Test
    public final void getCollisionTypeInfiniteTangent() {
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.INFINITE_TANGENT_IN_ONE_POINT
        );
        assertEquals(
            new GetCollisionType(
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
            ).getCollisionType(),
            CollisionType.INFINITE_TANGENT_IN_ONE_POINT
        );
    }
}
