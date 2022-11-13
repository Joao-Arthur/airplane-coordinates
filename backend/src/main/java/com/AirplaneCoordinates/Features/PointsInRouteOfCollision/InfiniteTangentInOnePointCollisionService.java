package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class InfiniteTangentInOnePointCollisionService implements CollisionPointService {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public InfiniteTangentInOnePointCollisionService(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        final var intersectionPoint = LinearFunction.intersectionPoint(
            this.pointA.fx,
            this.pointB.fx
        );
        if (intersectionPoint == null)
            return null;
        final var collisionPoint = LinearPoint.collisionPoint(
            this.pointA.linearPoint,
            this.pointB.linearPoint
        );
        if (collisionPoint == null)
            return null;
        final var y = this.pointA.isInfiniteTangent
            ? this.pointB.fx.execute(collisionPoint.y)
            : this.pointA.fx.execute(collisionPoint.y);
        final var collisionA = LinearPoint.collisionPoint(
            LinearPoint.from(
                this.pointA.isInfiniteTangent
                    ? y
                    : intersectionPoint.x,
                PreciseDecimal.from(0)
            ),
            LinearPoint.from(
                this.pointA.isInfiniteTangent
                    ? this.pointA.asCartesian.y
                    : this.pointA.asCartesian.x,
                Deg
                    .from(this.pointA.planePoint.vector.direction)
                    .getCosValueInQuadrant(
                        this.pointA.isInfiniteTangent
                            ? this.pointA.planePoint.vector.speed
                            : this.pointA.coefficient.times(this.pointA.planePoint.vector.speed)
                    )
            )
        );
        if (collisionA.x.smallerThan(PreciseDecimal.from(0)))
            return null;
        final var collisionB = LinearPoint.collisionPoint(
            LinearPoint.from(
                this.pointB.isInfiniteTangent
                    ? y
                    : intersectionPoint.x,
                PreciseDecimal.from(0)
            ),
            LinearPoint.from(
                this.pointB.isInfiniteTangent
                    ? this.pointB.asCartesian.y
                    : this.pointB.asCartesian.x,
                Deg
                    .from(this.pointB.planePoint.vector.direction)
                    .getCosValueInQuadrant(
                        this.pointB.isInfiniteTangent
                            ? this.pointB.planePoint.vector.speed
                            : this.pointB.coefficient.times(this.pointB.planePoint.vector.speed)
                    )
            )
        );
        if (collisionB.x.smallerThan(PreciseDecimal.from(0)))
            return null;
        final var timeUntilCollision = PreciseDecimal.min(
            collisionA.x,
            collisionB.x
        );
        final var timeDifferenceToPoint = collisionA.x.minus(collisionB.x).abs();

        return new CollisionDTOBuilder()
            .setA(this.pointA.planePoint.id)
            .setB(this.pointB.planePoint.id)
            .setTimeUntilCollision(timeUntilCollision.round())
            .setCollisionPoint(CartesianPoint.from(collisionPoint.y, y).round())
            .setTimeDifferenceToPoint(timeDifferenceToPoint.round())
            .build();
    }
}
