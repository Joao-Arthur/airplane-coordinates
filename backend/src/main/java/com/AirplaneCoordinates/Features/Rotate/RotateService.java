package com.AirplaneCoordinates.Features.Rotate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class RotateService {
    private final RotateInputDTO dto;

    public RotateService(final RotateInputDTO dto) {
        this.dto = dto;
    }

    public final RotateOutputDTO execute() {
        final var angleValue = Deg.from(this.dto.angle).normalized();
        final var offsetPoint = this.dto.point.toCartesian().minus(this.dto.centerOfRotation);
        final var pointAsPolar = offsetPoint.toPolar();
        final var rotatedPoint = pointAsPolar.rotate(angleValue);
        final var pointAsCartesian = rotatedPoint.toCartesian();
        final var unoffsetedPoint = pointAsCartesian.plus(this.dto.centerOfRotation);
    
        switch(this.dto.point.planeType) {
            case CARTESIAN:
                return new RotateOutputDTO(
                    PlanePoint.fromCartesian(unoffsetedPoint.round())
                );
            case POLAR:
                return new RotateOutputDTO(
                    PlanePoint.fromPolar(unoffsetedPoint.toPolar().round())
                );
            default:
                throw new RuntimeException("planeType is required"); 
        }
    }
}
