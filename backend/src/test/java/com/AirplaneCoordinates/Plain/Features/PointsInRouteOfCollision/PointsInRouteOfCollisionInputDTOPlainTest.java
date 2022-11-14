package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionInputDTO;
import com.AirplaneCoordinates.Plain.Core.Mechanics.VectorPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithVectorPlain;

public final class PointsInRouteOfCollisionInputDTOPlainTest {
    @Test
    public final void toObject() {
        final var plain = new ArrayList<PlanePointWithVectorPlain>();
        plain.add(
            new PlanePointWithVectorPlain(
                "YYZ",
                new PlanePointPlain(Plane.POLAR, "2", "2"),
                new VectorPlain("8", "-8")
            )
        );
        plain.add(
            new PlanePointWithVectorPlain(
                "007",
                new PlanePointPlain(Plane.CARTESIAN, "3", "3"),
                new VectorPlain("3", "-3")
            )
        );

        final var object = new ArrayList<PlanePointWithVector>();
        object.add(
            new PlanePointWithVector(
                "YYZ",
                PlanePoint.from(Plane.POLAR, PreciseDecimal.from(2), PreciseDecimal.from(2)),
                Vector.from(8, -8)
            )
        );
        object.add(
            new PlanePointWithVector(
                "007",
                PlanePoint.from(Plane.CARTESIAN, PreciseDecimal.from(3), PreciseDecimal.from(3)),
                Vector.from(3, -3)
            )
        );

        assertEquals(
            new PointsInRouteOfCollisionInputDTOPlain(
                plain,
                "200"
            ).toObject().toString(),
            new PointsInRouteOfCollisionInputDTO(
                object,
                PreciseDecimal.from(200)
            ).toString()
        );
    } 
}
