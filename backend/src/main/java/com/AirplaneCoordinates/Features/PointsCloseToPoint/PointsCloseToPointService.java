package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToPointService {
    private final PointsCloseToPointInputDTO dto;

    public PointsCloseToPointService(
        final PointsCloseToPointInputDTO dto
    ) {
        this.dto = dto;
    }

    public final List<PointsCloseToPointOutputDTO> execute() {
        return this.dto.points
            .stream()
            .map(point ->
                new PointsCloseToPointOutputDTO(
                    point.id,
                    CartesianPoint.distance(
                        point.point.toCartesian(),
                        CartesianPoint.from(0, 0)
                    )
                )
            )
            .filter(point ->
                point.distanceFromPoint.smallerOrEquals(this.dto.maxDistance)
            )
            .sorted((a, b) ->
                PreciseDecimal.compareAsc(
                    a.distanceFromPoint,
                    b.distanceFromPoint
                )
            )
            .collect(Collectors.toList());
    }
}
