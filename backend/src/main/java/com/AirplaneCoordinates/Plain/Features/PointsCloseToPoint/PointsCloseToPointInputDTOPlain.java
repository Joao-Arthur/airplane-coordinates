package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class PointsCloseToPointInputDTOPlain {
    public final List<PlanePointWithIdPlain> points;
    public final CartesianPointPlain point;
    public final String maxDistance;

    public PointsCloseToPointInputDTOPlain(
        final List<PlanePointWithIdPlain> points,
        final CartesianPointPlain point,
        final String maxDistance
    ) {
        this.points = points;
        this.point = point;
        this.maxDistance = maxDistance;
    }

    public final PointsCloseToPointInputDTO toObject() {
        return new PointsCloseToPointInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            this.point.toObject(),
            PreciseDecimal.from(maxDistance)
        );
    }  
}
