package com.AirplaneCoordinates.Features.Translate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class TranslateService {
    private final TranslateInputDTO dto;

    public TranslateService(final TranslateInputDTO dto) {
        this.dto = dto;
    }

    public final TranslateOutputDTO execute() {
        final var resultPoint = this.dto.point
            .toCartesian()
            .plus(this.dto.factor);

        switch (this.dto.point.planeType) {
            case CARTESIAN:
                return new TranslateOutputDTO(
                    PlanePoint.fromCartesian(
                        resultPoint.round()
                    )
                );
            case POLAR:
                return new TranslateOutputDTO(
                    PlanePoint.fromPolar(
                        resultPoint.toPolar().round()
                    )
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
