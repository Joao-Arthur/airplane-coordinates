package com.AirplaneCoordinates.Plain.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;

public final class CartesianPointPlain {
    public final String x;
    public final String y;

    public CartesianPointPlain(
        final String x,
        final String y
    ) {
        this.x = x;
        this.y = y;
    }

    public final CartesianPoint toObject() {
        return CartesianPoint.from(this.x, this.y);
    }
}
