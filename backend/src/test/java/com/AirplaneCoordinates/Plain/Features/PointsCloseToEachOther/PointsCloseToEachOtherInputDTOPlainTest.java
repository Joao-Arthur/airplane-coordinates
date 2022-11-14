package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class PointsCloseToEachOtherInputDTOPlainTest {
    @Test
    public final void toObject() {
        final var plain = new ArrayList<PlanePointWithIdPlain>();
        plain.add(new PlanePointWithIdPlain("YYZ", new PlanePointPlain(Plane.POLAR, "2", "2")));
        plain.add(new PlanePointWithIdPlain("007", new PlanePointPlain(Plane.CARTESIAN, "3", "3")));

        final var object = new ArrayList<PlanePointWithId>();
        object.add(new PlanePointWithId("YYZ", PlanePoint.from(Plane.POLAR, PreciseDecimal.from(2), PreciseDecimal.from(2))));
        object.add(new PlanePointWithId("007", PlanePoint.from(Plane.CARTESIAN, PreciseDecimal.from(3), PreciseDecimal.from(3))));

        assertEquals(
            new PointsCloseToEachOtherInputDTOPlain(
                plain,
                "200"
            ).toObject().toString(),
            new PointsCloseToEachOtherInputDTO(
                object,
                PreciseDecimal.from(200)
            ).toString()
        );
    }
}
