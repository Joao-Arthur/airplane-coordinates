package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToPointService {
    private final List<PlanePointWithId> points;
    private final PreciseDecimal maxDistance;

    public PointsCloseToPointService(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        this.points = points;
        this.maxDistance = maxDistance;
    }

    public final List<PointCloseToPointDTO> execute() {
        return this.points
            .stream()
            .map(point ->
                PointCloseToPointDTO.from(
                    point.id,
                    CartesianPoint.distance(
                        point.point.toCartesian(),
                        CartesianPoint.from(0, 0)
                    )
                )
            )
            .filter(point ->
                point.distanceFromPoint.smallerOrEquals(this.maxDistance)
            )
            .sorted((a, b) ->
                PreciseDecimal.compareAsc(a.distanceFromPoint, b.distanceFromPoint)
            )
            .collect(Collectors.toList());
    }
}
