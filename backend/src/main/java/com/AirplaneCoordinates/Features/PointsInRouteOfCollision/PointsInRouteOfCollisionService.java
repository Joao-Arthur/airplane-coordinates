package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Combination.Combination;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsInRouteOfCollisionService {
    private final PointsInRouteOfCollisionInputDTO dto;

    public PointsInRouteOfCollisionService(
        final PointsInRouteOfCollisionInputDTO dto
    ) {
        this.dto = dto;
    }

    public final List<PointsInRouteOfCollisionOutputDTO> execute() {
        return Combination
            .getCombinations(this.dto.points)
            .stream()
            .map(
                point -> new CollisionPointServiceFactory(
                    PointDTO.from(point.a),
                    PointDTO.from(point.b)
                )
                    .getService()
                    .getCollisionPoint()
            )
            .filter(point -> point != null)
            .filter(point ->
                point.timeDifferenceToPoint.smallerOrEquals(this.dto.maxTime)
            )
            .sorted((a, b) ->
                PreciseDecimal.compareAsc(
                    a.timeUntilCollision,
                    b.timeUntilCollision
                )
            )
            .collect(Collectors.toList());
    }
}
