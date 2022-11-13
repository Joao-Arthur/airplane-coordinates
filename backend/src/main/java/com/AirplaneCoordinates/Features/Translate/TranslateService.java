package com.AirplaneCoordinates.Features.Translate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class TranslateService {
    private final TranslateInputDTO dto;

    public TranslateService(final TranslateInputDTO dto) {
        this.dto = dto;
    }

    public final PlanePoint execute() {
        final var resultPoint = this.dto.point
            .toCartesian()
            .plus(this.dto.factor);

        switch (this.dto.point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(
                    resultPoint.round()
                );
            case POLAR:
                return PlanePoint.fromPolar(
                    resultPoint.toPolar().round()
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
