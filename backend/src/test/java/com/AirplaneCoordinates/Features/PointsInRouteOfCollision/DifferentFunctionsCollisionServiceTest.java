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

public final class DifferentFunctionsCollisionServiceTest {
    @Test
    public final void getCollisionPointNull() {
        assertNull(
            new DescribeFututePosition(
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
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 3, 5),
                    Vector.from(45, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 2)
                )
            ).getCollisionPoint()
        );
        assertNull(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, 0, 0),
                    Vector.from(179, 2)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, -3, 4),
                    Vector.from(170, 1)
                )
            ).getCollisionPoint()
        );
    }

    @Test
    public final void getCollisionPointSameSpeed() {
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(45, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145"),
                CartesianPoint.from(0, 2),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(55, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(125, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("3.486893591242196039675366833448743541140960839516955840655123547527881329058884126748735265163522056"),
                CartesianPoint.from("0", "2.856296013484229004321236969997001479267603224150638195223588254563391035055977065874605128250680717"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(65, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(115, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("4.732403166304997035867356652417659575970785240358470748834195983745747686660878385224077305115896278"),
                CartesianPoint.from("0", "4.289013841019117232712521582091844361371863148552137968598273053408510078997951160149480542967061069"),
                PreciseDecimal.from(0)
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(25, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(155, 1)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("2.206755837924983512973789406685409966553887449700976650397016993235401555684220432158920676558579735"),
                CartesianPoint.from("0", "0.9326153163099971856600123895991189026221260165027518356218648964784367667778130731062536465145457465"),
                PreciseDecimal.from(0)
            ).toString()
        );
    }

    @Test
    public final void getCollisionPointDifferentSpeed() {
        assertEquals(
            new DescribeFututePosition(
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
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from(
                    "2.062673283970396327583264965806297507053836178792920062805159503267122343364369339942827181983700487"
                ),
                CartesianPoint.from(
                    "11.09400992595559449137489744870944626058075426818938009420773925490068351504655400991424077297555073",
                    "3.074538370651166171293463459071132161578194943301124830031013599133839282956480570706156561037285264"
                ),
                PreciseDecimal.from("1.031336641985198163791632482903148753526918089396460031402579751633561171682184669971413590991850244")
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(45, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(135, 2)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641572"),
                CartesianPoint.from(0, 2),
                PreciseDecimal.from("1.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641573")
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(55, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(125, 4)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("0.871723397810549009918841708362185885285240209879238960163780886881970332264721031687183816290880514"),
                CartesianPoint.from("0", "2.856296013484229004321236969997001479267603224150638195223588254563391035055977065874605128250680717"),
                PreciseDecimal.from("2.615170193431647029756525125086557655855720629637716880491342660645910996794163095061551448872641542")
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(65, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(115, 2)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("2.366201583152498517933678326208829787985392620179235374417097991872873843330439192612038652557948139"),
                CartesianPoint.from("0", "4.289013841019117232712521582091844361371863148552137968598273053408510078997951160149480542967061069"),
                PreciseDecimal.from("2.366201583152498517933678326208829787985392620179235374417097991872873843330439192612038652557948139")
            ).toString()
        );
        assertEquals(
            new DescribeFututePosition(
                new PlanePointWithVector(
                    "1",
                    PlanePoint.from(Plane.CARTESIAN, -2, 0),
                    Vector.from(25, 1)
                ),
                new PlanePointWithVector(
                    "2",
                    PlanePoint.from(Plane.CARTESIAN, 2, 0),
                    Vector.from(155, 2)
                )
            ).getCollisionPoint().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "1",
                "2",
                PreciseDecimal.from("1.103377918962491756486894703342704983276943724850488325198508496617700777842110216079460338279289868"),
                CartesianPoint.from("0", "0.9326153163099971856600123895991189026221260165027518356218648964784367667778130731062536465145457465"),
                PreciseDecimal.from("1.103377918962491756486894703342704983276943724850488325198508496617700777842110216079460338279289867")
            ).toString()
        );
    }
}