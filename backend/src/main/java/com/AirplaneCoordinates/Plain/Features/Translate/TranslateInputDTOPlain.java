package com.AirplaneCoordinates.Plain.Features.Translate;

import com.AirplaneCoordinates.Features.Translate.TranslateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class TranslateInputDTOPlain {
    public final PlanePointPlain point;
    public final CartesianPointPlain factor;

    public TranslateInputDTOPlain(
        final PlanePointPlain point,
        final CartesianPointPlain factor
    ) {
        this.point = point;
        this.factor = factor;
    }

    public final TranslateInputDTO toObject() {
        return new TranslateInputDTO(
            this.point.toObject(),
            this.factor.toObject()
        );
    }   
}
