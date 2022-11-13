package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

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
            LinearPoint.from(
                this.pointA.asCartesian.y,
                Deg
                    .from(this.pointA.planePoint.vector.direction)
                    .getCosValueInQuadrant(this.pointA.planePoint.vector.speed)
            ),
            LinearPoint.from(
                this.pointB.asCartesian.y,
                Deg
                    .from(this.pointB.planePoint.vector.direction)
                    .getCosValueInQuadrant(this.pointB.planePoint.vector.speed)
            )
        );
        if (collisionPoint == null)
            return null;

        return new CollisionDTOBuilder()
            .setA(this.pointA.planePoint.id)
            .setB(this.pointB.planePoint.id)
            .setTimeUntilCollision(collisionPoint.x.round())
            .setCollisionPoint(
                CartesianPoint.from(
                    this.pointA.asCartesian.x,
                    collisionPoint.y
                ).round()
            )
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
