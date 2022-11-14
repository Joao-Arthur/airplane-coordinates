package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionInputDTO;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithVectorPlain;

public final class PointsInRouteOfCollisionInputDTOPlain {
    public final List<PlanePointWithVectorPlain> points;
    public final String maxTime;

    public PointsInRouteOfCollisionInputDTOPlain(
        final List<PlanePointWithVectorPlain> points,
        final String maxTime
    ) {
        this.points = points;
        this.maxTime = maxTime;
    }

    public final PointsInRouteOfCollisionInputDTO toObject() {
        return new PointsInRouteOfCollisionInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            PreciseDecimal.from(maxTime)
        );
    }  
}
