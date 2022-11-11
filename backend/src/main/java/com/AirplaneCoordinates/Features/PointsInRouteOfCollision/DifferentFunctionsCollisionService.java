package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;
import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Mechanics.LinearPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class DifferentFunctionsCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public DifferentFunctionsCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        final var cartesianA = this.pointA.point.toCartesian();
        final var cartesianB = this.pointB.point.toCartesian();

        final var fx = LinearFunction.from(
            cartesianA,
            this.pointA.vector.direction
        );
        final var gx = LinearFunction.from(
            cartesianB,
            this.pointB.vector.direction
        );
        final var intersectionPoint = LinearFunction.intersectionPoint(fx, gx);
        final var coefficientA = Deg
            .from(this.pointA.vector.direction)
            .toRad()
            .value
            .cos();
        final var coefficientB = Deg
            .from(this.pointB.vector.direction)
            .toRad()
            .value
            .cos();
        //final var collisionPoint = LinearPoint.collisionPoint(
        //    LinearPoint.from(
        //        cartesianA.x,
        //        coefficientA.times(this.pointA.vector.speed)
        //    ),
        //    LinearPoint.from(
        //        cartesianB.x,
        //        coefficientB.times(this.pointB.vector.speed)
        //    )
        //);
        //final var y = fx.execute(collisionPoint.x);

        final var collisionA = LinearPoint.collisionPoint(
            LinearPoint.from(
                intersectionPoint.x,
                PreciseDecimal.from(0)
            ),
            LinearPoint.from(
                cartesianA.x,
                coefficientA.times(this.pointA.vector.speed)
            )
        );
        if (collisionA.x.smallerThan(PreciseDecimal.from(0)))
            return null;
        final var collisionB = LinearPoint.collisionPoint(
            LinearPoint.from(
                intersectionPoint.x,
                PreciseDecimal.from(0)
            ),
            LinearPoint.from(
                cartesianB.x,
                coefficientB.times(this.pointB.vector.speed)
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
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(timeUntilCollision)
            .setCollisionPoint(intersectionPoint)
            .setTimeDifferenceToPoint(timeDifferenceToPoint)
            .build();
    }
}