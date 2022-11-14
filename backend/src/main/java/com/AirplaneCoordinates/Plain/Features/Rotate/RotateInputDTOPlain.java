package com.AirplaneCoordinates.Plain.Features.Rotate;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.Rotate.RotateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class RotateInputDTOPlain {
    public final PlanePointPlain point;
    public final CartesianPointPlain centerOfRotation;
    public final String angle;

    public RotateInputDTOPlain(
        final PlanePointPlain point,
        final CartesianPointPlain centerOfRotation,
        final String angle
    ) {
        this.point = point;
        this.centerOfRotation = centerOfRotation;
        this.angle = angle;
    }

    public final RotateInputDTO toObject() {
        return new RotateInputDTO(
            this.point.toObject(),
            this.centerOfRotation.toObject(),
            PreciseDecimal.from(this.angle)
        );
    }  
}
