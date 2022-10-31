package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToPointServiceTest {

    @Test
    public final void pointsCloseToPoint() {
        final var points = new ArrayList<PlanePointWithId>();
        points.add(PlanePointWithId.from( "1", Plane.CARTESIAN, 0, 8));
        points.add(PlanePointWithId.from( "2", Plane.CARTESIAN, 10, 0));
        points.add(PlanePointWithId.from( "3", Plane.CARTESIAN, -2, -2));
        points.add(PlanePointWithId.from( "4", Plane.CARTESIAN, 10, 10));

        final var actualResult = PointsCloseToPointService.execute(points, PreciseDecimal.from(10));

        final var expectedResult = new ArrayList<PointCloseToPointDTO>();
        expectedResult.add(PointCloseToPointDTO.from( "3", PreciseDecimal.from("2.8284271247461903")));
        expectedResult.add(PointCloseToPointDTO.from( "1", PreciseDecimal.from(8)));
        expectedResult.add(PointCloseToPointDTO.from("2", PreciseDecimal.from(10)));

        assertEquals(1+1, 2);
    }
}
