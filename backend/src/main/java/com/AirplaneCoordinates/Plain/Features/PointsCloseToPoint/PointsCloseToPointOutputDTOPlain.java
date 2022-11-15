package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointOutputDTO;

public final class PointsCloseToPointOutputDTOPlain {
    public final List<PointCloseToPointOutputDTOPlain> points;

    public PointsCloseToPointOutputDTOPlain(
        List<PointCloseToPointOutputDTOPlain> points
    ) {
        this.points = points;
    }

    public final PointsCloseToPointOutputDTO toObject() {
        return new PointsCloseToPointOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final PointsCloseToPointOutputDTOPlain fromObject(final PointsCloseToPointOutputDTO dto) {
        return new PointsCloseToPointOutputDTOPlain(
            dto.points
                .stream()
                .map(PointCloseToPointOutputDTOPlain::fromObject)
                .collect(Collectors.toList())
        );
    }
}
