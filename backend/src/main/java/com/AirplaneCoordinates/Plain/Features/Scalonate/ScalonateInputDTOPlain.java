package com.AirplaneCoordinates.Plain.Features.Scalonate;

import com.AirplaneCoordinates.Features.Scalonate.ScalonateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class ScalonateInputDTOPlain {
    public final PlanePointPlain point;
    public final CartesianPointPlain factor;

    public ScalonateInputDTOPlain(
        final PlanePointPlain point,
        final CartesianPointPlain factor
    ) {
        this.point = point;
        this.factor = factor;
    }

    public final ScalonateInputDTO toObject() {
        return new ScalonateInputDTO(
            this.point.toObject(),
            this.factor.toObject()
        );
    }   
}
