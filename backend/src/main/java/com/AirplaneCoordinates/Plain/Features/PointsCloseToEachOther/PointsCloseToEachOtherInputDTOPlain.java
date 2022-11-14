package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherInputDTO;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class PointsCloseToEachOtherInputDTOPlain {
    public final List<PlanePointWithIdPlain> points;
    public final String maxDistance;

    public PointsCloseToEachOtherInputDTOPlain(
        final List<PlanePointWithIdPlain> points,
        final String maxDistance
    ) {
        this.points = points;
        this.maxDistance = maxDistance;
    }

    public final PointsCloseToEachOtherInputDTO toObject() {
        return new PointsCloseToEachOtherInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            PreciseDecimal.from(maxDistance)
        );
    }  
}
