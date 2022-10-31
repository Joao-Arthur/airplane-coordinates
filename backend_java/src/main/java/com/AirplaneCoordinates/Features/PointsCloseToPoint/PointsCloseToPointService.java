package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToPointService {
    public final List<PointCloseToPointDTO> execute(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        return points
            .stream()
            .map(point ->
                new PointCloseToPointDTO(
                    point.id,
                    CartesianOperations.distance(point.getPoint().toCartesian(),CartesianPoint.from(0, 0))
                )
            )
            .filter(point ->
                PreciseDecimalOperations.smallerOrEquals(point.distanceFromPoint, maxDistance)
            )
            .sorted((a, b) ->
                PreciseDecimalOperations.greater(a.distanceFromPoint, b.distanceFromPoint) ? 1 : -1
            )
            .collect(Collectors.toList());
    }
}
