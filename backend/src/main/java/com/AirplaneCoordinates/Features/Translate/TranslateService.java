package com.AirplaneCoordinates.Features.Translate;

import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class TranslateService {
    private final TranslateInputDTO dto;

    public TranslateService(final TranslateInputDTO dto) {
        this.dto = dto;
    }

    public final TranslateOutputDTO execute() {
        return new TranslateOutputDTO(
            this.dto.points
                .stream()
                .map(planePointWithId -> {
                    final var resultPoint = planePointWithId.point
                        .toCartesian()
                        .plus(this.dto.factor);
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
