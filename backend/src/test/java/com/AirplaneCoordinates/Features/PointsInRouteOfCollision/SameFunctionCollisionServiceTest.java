package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class SameFunctionCollisionServiceTest {
    @Test
    public final void getCollisionPointNull() {
        assertNull(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 1),
                    Vector.from(45, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, 3),
                    Vector.from(45, 1)
                ))
            ).getCollisionPoint()
        );
    }

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
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("0.6388765649999399132597639053517932101258909598890073497916849272601488358965156855469755452510806501"),
                CartesianPoint.from(
                    "4.285714285714285714285714285714285714285714285714285714285714285714285714285714285714285714285714286",
                    "2.142857142857142857142857142857142857142857142857142857142857142857142857142857142857142857142857143"
                ),
                PreciseDecimal.from(0)
            ).toString()
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
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("0.2795084971874737120511467085914095294300772949514407155338621556763151157047256124268018010473477843"),
                CartesianPoint.from("1.25", "3.125"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 1),
                    Vector.from(45, 2)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, 3),
                    Vector.from(45, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283148"),
                CartesianPoint.from(3, 5),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -1, 4),
                    Vector.from(45, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 1, 6),
                    Vector.from(225, 1)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641572"),
                CartesianPoint.from(0, 5),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new SameFunctionCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 2),
                    Vector.from(0, 2)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 2),
                    Vector.from(180, 9)
                ))
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from("0.3636363636363636363636363636363636363636363636363636363636363636363636363636363636363636363636363635"),
                CartesianPoint.from("-1.272727272727272727272727272727272727272727272727272727272727272727272727272727272727272727272727273", "2"),
                PreciseDecimal.from(0)
            ).toString()
        );
    }
}
