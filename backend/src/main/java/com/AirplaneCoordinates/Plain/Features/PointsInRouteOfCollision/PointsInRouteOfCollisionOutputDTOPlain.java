package com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionOutputDTO;

public final class PointsInRouteOfCollisionOutputDTOPlain {
    public final List<PointInRouteOfCollisionOutputDTOPlain> points;

    public PointsInRouteOfCollisionOutputDTOPlain(
        List<PointInRouteOfCollisionOutputDTOPlain> points
    ) {
        this.points = points;
    }

    public final PointsInRouteOfCollisionOutputDTO toObject() {
        return new PointsInRouteOfCollisionOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final PointsInRouteOfCollisionOutputDTOPlain fromObject(final PointsInRouteOfCollisionOutputDTO dto) {
        return new PointsInRouteOfCollisionOutputDTOPlain(
            dto.points
                .stream()
                .map(point -> PointInRouteOfCollisionOutputDTOPlain.fromObject(point))
                .collect(Collectors.toList())
        );
    }
}
