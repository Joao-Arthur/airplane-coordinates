package com.AirplaneCoordinates.Plain.Features.Rotate;

import com.AirplaneCoordinates.Features.Rotate.RotateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class RotateOutputDTOPlain {
    public final PlanePointPlain point;

    public RotateOutputDTOPlain(final PlanePointPlain point) {
        this.point = point;
    }

    public final RotateOutputDTO toObject() {
        return new RotateOutputDTO(
            this.point.toObject()
        );
    }

    public static final RotateOutputDTOPlain fromObject(final RotateOutputDTO dto) {
        return new RotateOutputDTOPlain(
            PlanePointPlain.fromObject(dto.point)
        );
    }
}
