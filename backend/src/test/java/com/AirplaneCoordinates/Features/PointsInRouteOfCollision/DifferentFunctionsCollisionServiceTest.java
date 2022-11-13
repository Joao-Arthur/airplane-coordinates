package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class DifferentFunctionsCollisionServiceTest {
    @Test
    public final void getCollisionPointNull() {
        assertNull(
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
            ).getCollisionPoint()
        );
        assertNull(
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
            ).getCollisionPoint()
        );
    }

    @Test
    public final void getCollisionPointSameSpeed() {
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
                PreciseDecimal.from("3.486893591242196039675366833448743541140960839516955840655123547527881329058884126748735265163522056"),
                CartesianPoint.from("0", "2.856296013484229004321236969997001479267603224150638195223588254563391035055977065874605128250680718"),
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
                PreciseDecimal.from("4.732403166304997035867356652417659575970785240358470748834195983745747686660878385224077305115896275"),
                CartesianPoint.from("0", "4.28901384101911723271252158209184436137186314855213796859827305340851007899795116014948054296706107"),
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
                PreciseDecimal.from("2.206755837924983512973789406685409966553887449700976650397016993235401555684220432158920676558579734"),
                CartesianPoint.from("0", "0.9326153163099971856600123895991189026221260165027518356218648964784367667778130731062536465145457468"),
                PreciseDecimal.from(0)
            ).toString()
        );
    }

    @Test
    public final void getCollisionPointDifferentSpeed() {
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
            ).getCollisionPoint().toString(),
            new CollisionDTO(
                "1",
                "2",
                PreciseDecimal.from(
                    "2.609902191542677500469973584804738125240122490292839939099618811199830171909999591660616865167562112"
                ),
                CartesianPoint.from(
                    "11.91485328731401625070496037720710718786018373543925990864942821679974525786499938749092529775134317",
                    "3.21927520219408414791113521017034269993719666608248158304415726206524988169837824530969366909604842"
                ),
                PreciseDecimal.from("0.900860831069461218090526025195134499133509143336760227414255746881140504517139657460103845324889316")
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
                PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641572"),
                CartesianPoint.from(0, 2),
                PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641574")
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
                PreciseDecimal.from("0.8717233978105490099188417083621858852852402098792389601637808868819703322647210316871838162908805139"),
                CartesianPoint.from("0", "2.856296013484229004321236969997001479267603224150638195223588254563391035055977065874605128250680718"),
                PreciseDecimal.from("2.615170193431647029756525125086557655855720629637716880491342660645910996794163095061551448872641542")
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
                PreciseDecimal.from("2.366201583152498517933678326208829787985392620179235374417097991872873843330439192612038652557948138"),
                CartesianPoint.from("0", "4.28901384101911723271252158209184436137186314855213796859827305340851007899795116014948054296706107"),
                PreciseDecimal.from("2.366201583152498517933678326208829787985392620179235374417097991872873843330439192612038652557948142")
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
                PreciseDecimal.from("1.103377918962491756486894703342704983276943724850488325198508496617700777842110216079460338279289867"),
                CartesianPoint.from("0", "0.9326153163099971856600123895991189026221260165027518356218648964784367667778130731062536465145457468"),
                PreciseDecimal.from("1.103377918962491756486894703342704983276943724850488325198508496617700777842110216079460338279289869")
            ).toString()
        );
    }
}