package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Combination.Combination;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToEachOtherService {
    private final List<PlanePointWithId> points;
    private final PreciseDecimal maxDistance;

    public PointsCloseToEachOtherService(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        this.points = points;
        this.maxDistance = maxDistance;
    }

    public final List<PointCloseToEachOtherDTO> execute() {
        return Combination
            .getCombinations(this.points)
            .stream()
            .map(point ->
                PointCloseToEachOtherDTO.from(
                    point.a.id,
                    point.b.id,
                    CartesianPoint.distance(
                        point.a.point.toCartesian(),
                        point.b.point.toCartesian()
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
