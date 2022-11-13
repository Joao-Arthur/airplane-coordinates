package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class SameFunctionCollisionService implements CollisionPointService {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public SameFunctionCollisionService(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final PointsInRouteOfCollisionOutputDTO getCollisionPoint() {
        final var collisionPoint = LinearPoint.collisionPoint(
            this.pointA.linearPoint,
            this.pointB.linearPoint
        );
        if (collisionPoint == null)
            return null;
        final var y = this.pointA.fx.execute(collisionPoint.y);
        final var collisionA = LinearPoint.collisionPoint(
            LinearPoint.from(
                collisionPoint.y,
                PreciseDecimal.from(0)
            ),
            this.pointA.linearPoint
        );
        if (collisionA.x.smallerThan(PreciseDecimal.from(0)))
            return null;
        final var collisionB = LinearPoint.collisionPoint(
            LinearPoint.from(
                collisionPoint.y,
                PreciseDecimal.from(0)
            ),
            this.pointB.linearPoint
        );
        if (collisionB.x.smallerThan(PreciseDecimal.from(0)))
            return null;
        final var timeUntilCollision = PreciseDecimal.min(
            collisionA.x,
            collisionB.x
        );
        final var timeDifferenceToPoint = collisionA.x.minus(collisionB.x).abs();

        return new PointsInRouteOfCollisionOutputDTOBuilder()
            .setA(this.pointA.planePoint.id)
            .setB(this.pointB.planePoint.id)
            .setTimeUntilCollision(timeUntilCollision.round())
            .setCollisionPoint(CartesianPoint.from(collisionPoint.y, y).round())
            .setTimeDifferenceToPoint(timeDifferenceToPoint.round())
            .build();
    }
}
