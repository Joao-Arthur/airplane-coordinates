package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class PointsCloseToPointInputDTOPlainTest {
    @Test
    public final void toObject() {
        final var plain = new ArrayList<PlanePointWithIdPlain>();
        plain.add(new PlanePointWithIdPlain("A", new PlanePointPlain(Plane.POLAR, "5", "5")));
        plain.add(new PlanePointWithIdPlain("N", new PlanePointPlain(Plane.CARTESIAN, "-9", "-9")));

        final var object = new ArrayList<PlanePointWithId>();
        object.add(new PlanePointWithId("A", PlanePoint.from(Plane.POLAR, PreciseDecimal.from(5), PreciseDecimal.from(5))));
        object.add(new PlanePointWithId("N", PlanePoint.from(Plane.CARTESIAN, PreciseDecimal.from(-9), PreciseDecimal.from(-9))));

        assertEquals(
            new PointsCloseToPointInputDTOPlain(
                plain,
                new CartesianPointPlain("2", "-8"),
                "2.2"
            ).toObject().toString(),
            new PointsCloseToPointInputDTO(
                object,
                CartesianPoint.from(2, -8),
                PreciseDecimal.from("2.2")
            ).toString()
        );
    }
}
