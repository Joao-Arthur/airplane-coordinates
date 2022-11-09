package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToPointService {
    public static final List<PointCloseToPointDTO> execute(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        return points
            .stream()
            .map(point ->
                PointCloseToPointDTO.from(
                    point.id,
                    CartesianOperations.distance(
                        point.point.toCartesian(),
                        CartesianPoint.from(0, 0)
                    )
                )
            )
            .filter(point ->
                point.distanceFromPoint.smallerOrEquals(maxDistance)
            )
            .sorted((a, b) ->
                PreciseDecimal.compare(a.distanceFromPoint, b.distanceFromPoint)
            )
            .collect(Collectors.toList());
    }
}
