package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCollisionDTOBuilder {
    public String a;
    public String b;
    public PreciseDecimal timeUntilCollision;
    public CartesianPoint collisionPoint;
    public PreciseDecimal timeDifferenceToPoint;

    public final PointsCollisionDTOBuilder setA(final String a) {
        this.a = a;
        return this;
    }

    public final PointsCollisionDTOBuilder setB(final String b) {
        this.b = b;
        return this;
    }

    public final PointsCollisionDTOBuilder setTimeUntilCollision(final PreciseDecimal timeUntilCollision) {
        this.timeUntilCollision = timeUntilCollision;
        return this;
    }

    public final PointsCollisionDTOBuilder setCollisionPoint(final CartesianPoint collisionPoint) {
        this.collisionPoint = collisionPoint;
        return this;
    }

    public final PointsCollisionDTOBuilder setTimeDifferenceToPoint(final PreciseDecimal timeDifferenceToPoint) {
        this.timeDifferenceToPoint = timeDifferenceToPoint;
        return this;
    }

    public final PointsCollisionDTO build() {
        return new PointsCollisionDTO(
            this.a,
            this.b,
            this.timeUntilCollision,
            this.collisionPoint,
            this.timeDifferenceToPoint
        );
    }
}
