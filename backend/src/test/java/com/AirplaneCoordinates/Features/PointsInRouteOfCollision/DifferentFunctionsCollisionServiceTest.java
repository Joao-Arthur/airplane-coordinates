package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class DifferentFunctionsCollisionServiceTest {
    @Test
    public final void getCollisionPoint() {
        assertEquals(
            new DifferentFunctionsCollisionService(
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
            ).getCollisionPoint(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from(
                    "0.0260990219154267750046997358480473812524012249029283993909961881119983017190999959166061686516756211"
                ),
                CartesianPoint.from(
                    "11.91485328731401625070496037720710718786018373543925990864942821679974525786499938749092529775134317",
                    "3.21927520219408414791113521017034269993719666608248158304415726206524988169837824530969366909604842"
                ),
                PreciseDecimal.from("0.6760535826070009687074001861519271436223251018229916339117787235041958335663278539075379734468146643")
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
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
            ).getCollisionPoint(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.3662015832"),
                CartesianPoint.from("0", "4.289013841"),
                PreciseDecimal.from("2.3662015832")
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 3, 5),
                    Vector.from(45, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 2)
                ))
            ).getCollisionPoint(),
            null
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(45, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145"),
                CartesianPoint.from(0, 2),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(55, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(125, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("3.4868935912"),
                CartesianPoint.from("0", "2.8562960135"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(65, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(115, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("4.7324031663"),
                CartesianPoint.from("0", "4.289013841"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(25, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(155, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.2067558379"),
                CartesianPoint.from("0", "0.9326153163"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(45, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 2)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("1.4142135624"),
                CartesianPoint.from("0", "1.4142135624"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(55, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(125, 4)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.6151701934"),
                CartesianPoint.from("0", "2.8562960135"),
                PreciseDecimal.from("0.8717233978")
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(65, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(115, 2)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.3662015832"),
                CartesianPoint.from("0", "4.289013841"),
                PreciseDecimal.from("2.3662015832")
            ).toString()
        );
        assertEquals(
            new DifferentFunctionsCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(25, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(155, 2)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("1.1033779190"),
                CartesianPoint.from("0", "0.9326153163"),
                PreciseDecimal.from("1.103377919")
            ).toString()
        );
    }
}