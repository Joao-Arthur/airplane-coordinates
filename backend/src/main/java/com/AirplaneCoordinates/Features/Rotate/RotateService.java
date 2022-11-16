package com.AirplaneCoordinates.Features.Rotate;

import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class RotateService {
    private final RotateInputDTO dto;

    public RotateService(final RotateInputDTO dto) {
        this.dto = dto;
    }

    public final RotateOutputDTO execute() {
        return new RotateOutputDTO(
            this.dto.points
                .stream()
                .map(planePointWithId -> {
                    final var angleValue = Deg.from(this.dto.angle).normalized();
                    final var offsetPoint = planePointWithId.point.toCartesian().minus(this.dto.centerOfRotation);
                    final var pointAsPolar = offsetPoint.toPolar();
                    final var rotatedPoint = pointAsPolar.rotate(angleValue);
                    final var pointAsCartesian = rotatedPoint.toCartesian();
                    final var unoffsetedPoint = pointAsCartesian.plus(this.dto.centerOfRotation);
                    switch(planePointWithId.point.planeType) {
                        case CARTESIAN:
                            return new PlanePointWithId(
                                planePointWithId.id,
                                PlanePoint.fromCartesian(unoffsetedPoint.round())
                            );
                        case POLAR:
                            return new PlanePointWithId(
                                planePointWithId.id,
                                PlanePoint.fromPolar(unoffsetedPoint.toPolar().round())
                            );
                        default:
                            throw new RuntimeException("planeType is required"); 
                    }
                })
                .collect(Collectors.toList())
            );
    }
}
