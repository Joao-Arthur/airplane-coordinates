package com.AirplaneCoordinates.Plain.Features.Scalonate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Features.Scalonate.ScalonateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class ScalonateInputDTOPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new ScalonateInputDTOPlain(
                new CustomArrayList<PlanePointWithIdPlain>()
                    .insert(new PlanePointWithIdPlain("A", new PlanePointPlain(Plane.CARTESIAN, "8", "-0.1"))),
                new CartesianPointPlain("2", "0.5")
            ).toObject().toString(),
            new ScalonateInputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(
                        new PlanePointWithId(
                            "A",
                            PlanePoint.from(
                                Plane.CARTESIAN,
                                PreciseDecimal.from("8"),
                                PreciseDecimal.from("-0.1")
                            )
                        )
                    ),
                CartesianPoint.from(
                    PreciseDecimal.from("2"),
                    PreciseDecimal.from("0.5")
                )
            ).toString()
        );
    }
}
