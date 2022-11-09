package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CollisionDTOBuilder {
    public String a;
    public String b;
    public PreciseDecimal timeUntilCollision;
    public CartesianPoint collisionPoint;
    public PreciseDecimal timeDifferenceToPoint;

    public final CollisionDTOBuilder setA(final String a) {
        this.a = a;
        return this;
    }

    public final CollisionDTOBuilder setB(final String b) {
        this.b = b;
        return this;
    }

    public final CollisionDTOBuilder setTimeUntilCollision(final PreciseDecimal timeUntilCollision) {
        this.timeUntilCollision = timeUntilCollision;
        return this;
    }

    public final CollisionDTOBuilder setCollisionPoint(final CartesianPoint collisionPoint) {
        this.collisionPoint = collisionPoint;
        return this;
    }

    public final CollisionDTOBuilder setTimeDifferenceToPoint(final PreciseDecimal timeDifferenceToPoint) {
        this.timeDifferenceToPoint = timeDifferenceToPoint;
        return this;
    }

    public final CollisionDTO build() {
        return new CollisionDTO(
            this.a,
            this.b,
            this.timeUntilCollision,
            this.collisionPoint,
            this.timeDifferenceToPoint
        );
    }
}
