package com.AirplaneCoordinates.Plain.Features.DTO;

import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;
import com.AirplaneCoordinates.Plain.Core.Mechanics.VectorPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class PlanePointWithVectorPlain {
    public final String id;
    public final PlanePointPlain point;
    public final VectorPlain vector;

    public PlanePointWithVectorPlain(
        final String id,
        final PlanePointPlain point,
        final VectorPlain vector
    ) {
        this.id = id;
        this.point = point;
        this.vector = vector;
    }

    public final PlanePointWithVector toObject() {
        return new PlanePointWithVector(
            id,
            point.toObject(),
            vector.toObject()
        );
    }
}
