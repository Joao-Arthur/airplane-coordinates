package com.AirplaneCoordinates.Plain.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Features.Rotate.RotateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class RotateOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new RotateOutputDTOPlain(
                new CustomArrayList<PlanePointWithIdPlain>()
                    .insert(
                        new PlanePointWithIdPlain(
                            "A",
                            new PlanePointPlain(Plane.POLAR, "1", "2")
                        )
                    )
            ).toObject().toString(),
            new RotateOutputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(
                        new PlanePointWithId(
                            "A",
                            PlanePoint.from(Plane.POLAR, 1, 2)
                        )
                    )
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            RotateOutputDTOPlain.fromObject(
                new RotateOutputDTO(
                    new CustomArrayList<PlanePointWithId>()
                        .insert(
                            new PlanePointWithId("A", PlanePoint.from(Plane.POLAR, 1, 2))
                        )
                )
            ).toObject().toString(),
            new RotateOutputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(
                        new PlanePointWithId("A", PlanePoint.from(Plane.POLAR, 1, 2))
                    )
            ).toString()
        );
    }
}
