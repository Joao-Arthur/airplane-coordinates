package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class InfiniteTangentSameXCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public InfiniteTangentSameXCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        final var collisionPoint = LinearPoint.collisionPoint(
            LinearPoint.from(
                this.pointA.point.toCartesian().y,
                this.pointA.vector.direction.equals(PreciseDecimal.from(90))
                    ? this.pointA.vector.speed
                    : this.pointA.vector.speed.opposite()
            ),
            LinearPoint.from(
                this.pointB.point.toCartesian().y,
                this.pointB.vector.direction.equals(PreciseDecimal.from(90))
                    ? this.pointB.vector.speed
                    : this.pointB.vector.speed.opposite()
            )
        );

        return new CollisionDTOBuilder()
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(collisionPoint.x)
            .setCollisionPoint(
                CartesianPoint.from(
                    this.pointA.point.toCartesian().x,
                    collisionPoint.y
                )
            )
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
