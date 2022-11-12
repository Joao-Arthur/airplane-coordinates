package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class InfiniteTangentSameXCollisionService implements CollisionPointService {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public InfiniteTangentSameXCollisionService(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        final var collisionPoint = LinearPoint.collisionPoint(
            this.pointA.linearPoint,
            this.pointB.linearPoint
        );

        return new CollisionDTOBuilder()
            .setA(this.pointA.planePoint.id)
            .setB(this.pointB.planePoint.id)
            .setTimeUntilCollision(collisionPoint.x)
            .setCollisionPoint(
                CartesianPoint.from(
                    this.pointA.asCartesian.x,
                    collisionPoint.y
                )
            )
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
