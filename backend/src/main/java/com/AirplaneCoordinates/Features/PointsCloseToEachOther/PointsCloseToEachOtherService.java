package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToEachOtherService {
    public static final List<PointCloseToEachOtherDTO> execute(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        final var pointsCombination = new ArrayList<PointCombination>();
        for (int i = 0; i < points.size() - 1; i++)
            for (int j = i + 1; j < points.size(); j++)
                pointsCombination.add(
                    new PointCombination(
                        points.get(i),
                        points.get(j)
                    )
                );

        return pointsCombination
            .stream()
            .map(point ->
                PointCloseToEachOtherDTO.from(
                    point.a.id,
                    point.b.id,
                    CartesianOperations.distance(
                        point.a.getPoint().toCartesian(),
                        point.b.getPoint().toCartesian()
                    )
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