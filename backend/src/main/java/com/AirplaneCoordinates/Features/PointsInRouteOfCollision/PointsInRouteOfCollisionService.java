package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

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

    public final PointsInRouteOfCollisionOutputDTO execute() {
        return new PointsInRouteOfCollisionOutputDTO(
            Combination
                .getCombinations(this.dto.points)
                .stream()
                .map(
                    point -> new DescribeFututePosition(
                        point.a,
                        point.b
                    )
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
                .collect(Collectors.toList())
        );
    }
}
