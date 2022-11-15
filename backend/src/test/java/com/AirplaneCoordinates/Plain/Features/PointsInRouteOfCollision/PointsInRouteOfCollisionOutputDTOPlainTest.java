package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointInRouteOfCollisionOutputDTO;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;

public final class PointsInRouteOfCollisionOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        final var plainList = new ArrayList<PointInRouteOfCollisionOutputDTOPlain>();
        plainList.add(
            new PointInRouteOfCollisionOutputDTOPlain(
                "B",
                "J",
                "0.27",
                new CartesianPointPlain("3", "8"),
                "8.3"
            )
        );
        plainList.add(
            new PointInRouteOfCollisionOutputDTOPlain(
                "A",
                "RR",
                "5",
                new CartesianPointPlain("9", "-2"),
                "-1"
            )
        );

        final var objectList = new ArrayList<PointInRouteOfCollisionOutputDTO>();
        objectList.add(
            new PointInRouteOfCollisionOutputDTO(
                "B",
                "J",
                PreciseDecimal.from("0.27"),
                CartesianPoint.from(3, 8),
                PreciseDecimal.from("8.3")
            )
        );
        objectList.add(
            new PointInRouteOfCollisionOutputDTO(
                "A",
                "RR",
                PreciseDecimal.from(5),
                CartesianPoint.from(9, -2),
                PreciseDecimal.from(-1)
            )
        );
        
        assertEquals(
            new PointsInRouteOfCollisionOutputDTOPlain(
                plainList
            ).toObject().toString(),
            new PointsInRouteOfCollisionOutputDTO(
                objectList
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        final var objectList = new ArrayList<PointInRouteOfCollisionOutputDTO>();
        objectList.add(
            new PointInRouteOfCollisionOutputDTO(
                "B",
                "J",
                PreciseDecimal.from("0.27"),
                CartesianPoint.from(3, 8),
                PreciseDecimal.from("8.3")
            )
        );
        objectList.add(
            new PointInRouteOfCollisionOutputDTO(
                "A",
                "RR",
                PreciseDecimal.from(5),
                CartesianPoint.from(9, -2),
                PreciseDecimal.from(-1)
            )
        );
        
        assertEquals(
            PointsInRouteOfCollisionOutputDTOPlain.fromObject(
                new PointsInRouteOfCollisionOutputDTO(objectList)
            ).toObject().toString(),
            new PointsInRouteOfCollisionOutputDTO(
                objectList
            ).toString()
        );
    }
}
