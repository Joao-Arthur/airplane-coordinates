package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointInRouteOfCollisionOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;

public final class PointInRouteOfCollisionOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new PointInRouteOfCollisionOutputDTOPlain(
                "B",
                "J",
                "0.27",
                new CartesianPointPlain("3", "8"),
                "8.3"
            ).toObject().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "B",
                "J",
                PreciseDecimal.from("0.27"),
                CartesianPoint.from(3, 8),
                PreciseDecimal.from("8.3")
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            PointInRouteOfCollisionOutputDTOPlain.fromObject(
                new PointInRouteOfCollisionOutputDTO(
                    "B",
                    "J",
                    PreciseDecimal.from("0.27"),
                    CartesianPoint.from(3, 8),
                    PreciseDecimal.from("8.3")
                )
            ).toObject().toString(),
            new PointInRouteOfCollisionOutputDTO(
                "B",
                "J",
                PreciseDecimal.from("0.27"),
                CartesianPoint.from(3, 8),
                PreciseDecimal.from("8.3")
            ).toString()
        );
    }
}
