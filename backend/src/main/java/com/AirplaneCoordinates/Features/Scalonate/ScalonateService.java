package com.AirplaneCoordinates.Features.Scalonate;

import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class ScalonateService {
    private final ScalonateInputDTO dto;

    public ScalonateService(final ScalonateInputDTO dto) {
        this.dto = dto;
    }

    public final ScalonateOutputDTO execute() {
        return new ScalonateOutputDTO(
            this.dto.points
                .stream()
                .map(planePointWithId -> {
                    final var resultPoint = planePointWithId.point
                        .toCartesian()
                        .times(this.dto.factor);
                    switch (planePointWithId.point.planeType) {
                        case CARTESIAN:
                            return new PlanePointWithId(
                                planePointWithId.id,
                                PlanePoint.fromCartesian(
                                    resultPoint.round()
                                )
                            );
                        case POLAR:
                            return new PlanePointWithId(
                                planePointWithId.id,
                                PlanePoint.fromPolar(
                                    resultPoint.toPolar().round()
                                )
                            );
                        default:
                            throw new RuntimeException("planeType is required");
                    }
                })
                .collect(Collectors.toList())
        );
    }
}
