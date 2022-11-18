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

public final class InfiniteTangentInOnePointCollisionServiceTest {
    @Test
    public final void getCollisionPointNull() {
        assertNull(
            new InfiniteTangentInOnePointCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 0, -10),
                    Vector.from(270, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 10, 0),
                    Vector.from(180, 4)
                ))
            ).getCollisionPoint()
        );
    }

    @Test
    public final void getCollisionPointSameSpeed() {
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 0, -10),
                    Vector.from(90, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 10, 0),
                    Vector.from(180, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(10),
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new InfiniteTangentInOnePointCollisionService(
                PointDTO.from(new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 5),
                    Vector.from(90, 1)
                )),
                PointDTO.from(new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 8, 10),
                    Vector.from(
                        "206.56505117707798935157219372045329467120421429964522102798601631528806582148474061170857381060216472",
                        "1"
                    )
                ))
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(0),
                CartesianPoint.from(-2, 5),
                PreciseDecimal.from("11.18033988749894848204586834365638117720309179805762862135448622705260462818902449707207204189391137")
            ).toString()
        );
    }

    @Test
    public final void getCollisionPointDifferentSpeed() {
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 0, -10),
                    Vector.from(90, 2)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 10, 0),
                    Vector.from(180, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(5),
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(5)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 0, -10),
                    Vector.from(90, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 10, 0),
                    Vector.from(180, 2)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(5),
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(5)
            ).toString()
        );
        assertEquals(
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
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("1.964070915860131412524371199120117550314996467309844788348954528498946877170614514007384895855467296"),
                CartesianPoint.from("-3", "0.566678146461001673595948378754602400771681766524220830645816426453400736544852676956858203138495283"),
                PreciseDecimal.from("2.469250937678866913879680422125280048913321766165934381005229045047652386284532809035756901006037421")
            ).toString()
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
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("1.672057133434589024839524231398375705926727285671584141803161207775357958962343615741435515147868357"),
                CartesianPoint.from("4", "14.03234280060753414903714538839025423556036371402950485081896724665214775377406169444861309088721014"),
                PreciseDecimal.from("0.808082163228660559648443527911390898354730079930781684039245342085916211892846289540547206492346343")
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 2, 22),
                    Vector.from(270, 4)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -3, 2),
                    Vector.from(0, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(5),
                CartesianPoint.from(2, 2),
                PreciseDecimal.from(0)
            ).toString()
        );
    }
}
