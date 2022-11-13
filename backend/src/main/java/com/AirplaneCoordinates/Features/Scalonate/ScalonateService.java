package com.AirplaneCoordinates.Features.Scalonate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class ScalonateService {
    private final ScalonateInputDTO dto;

    public ScalonateService(final ScalonateInputDTO dto) {
        this.dto = dto;
    }

    public final ScalonateOutputDTO execute() {
        final var resultPoint = this.dto.point
            .toCartesian()
            .times(this.dto.factor);

        switch (this.dto.point.planeType) {
            case CARTESIAN:
                return new ScalonateOutputDTO(
                    PlanePoint.fromCartesian(
                        resultPoint.round()
                    )
                );
            case POLAR:
                return new ScalonateOutputDTO(
                    PlanePoint.fromPolar(
                        resultPoint.toPolar().round()
                    )
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
