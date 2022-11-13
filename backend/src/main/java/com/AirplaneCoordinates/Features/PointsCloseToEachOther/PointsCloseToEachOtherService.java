package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Combination.Combination;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToEachOtherService {
    private final PointsCloseToEachOtherInputDTO dto;

    public PointsCloseToEachOtherService(
        final PointsCloseToEachOtherInputDTO dto
    ) {
        this.dto = dto;
    }

    public final PointsCloseToEachOtherOutputDTO execute() {
        return new PointsCloseToEachOtherOutputDTO(
            Combination
                .getCombinations(this.dto.points)
                .stream()
                .map(point ->
                    new PointCloseToEachOtherOutputDTO(
                        point.a.id,
                        point.b.id,
                        CartesianPoint.distance(
                            point.a.point.toCartesian(),
                            point.b.point.toCartesian()
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
                .collect(Collectors.toList())
        );
    }
}
