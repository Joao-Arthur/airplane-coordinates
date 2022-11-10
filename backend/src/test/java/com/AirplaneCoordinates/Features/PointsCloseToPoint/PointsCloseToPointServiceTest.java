package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToPointServiceTest {
    @Test
    public final void pointsCloseToPoint() {
        final var points = new ArrayList<PlanePointWithId>();
        points.add(PlanePointWithId.from("1", PlanePoint.from(Plane.CARTESIAN, 0, 8)));
        points.add(PlanePointWithId.from("2", PlanePoint.from(Plane.CARTESIAN, 10, 0)));
        points.add(PlanePointWithId.from("3", PlanePoint.from(Plane.CARTESIAN, -2, -2)));
        points.add(PlanePointWithId.from("4", PlanePoint.from(Plane.CARTESIAN, 10, 10)));

        final var actual = new PointsCloseToPointService(points, PreciseDecimal.from(10)).execute();

        final var expected = new ArrayList<PointCloseToPointDTO>();
        expected.add(PointCloseToPointDTO.from("3", "2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145"));
        expected.add(PointCloseToPointDTO.from("1", 8));
        expected.add(PointCloseToPointDTO.from("2", 10));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }
}
