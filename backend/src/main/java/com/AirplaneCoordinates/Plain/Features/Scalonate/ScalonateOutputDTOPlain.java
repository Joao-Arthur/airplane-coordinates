package com.AirplaneCoordinates.Plain.Features.Scalonate;

import com.AirplaneCoordinates.Features.Scalonate.ScalonateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class ScalonateOutputDTOPlain {
    public final PlanePointPlain point;

    public ScalonateOutputDTOPlain(final PlanePointPlain point) {
        this.point = point;
    }

    public final ScalonateOutputDTO toObject() {
        return new ScalonateOutputDTO(
            this.point.toObject()
        );
    }

    public static final ScalonateOutputDTOPlain fromObject(final ScalonateOutputDTO dto) {
        return new ScalonateOutputDTOPlain(
            PlanePointPlain.fromObject(dto.point)
        );
    }
}
