package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
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
        final var intersectionPoint = LinearFunction.intersectionPoint(fx, gx);

        /*
        final var { y: x } = mechanics.collision({
            a: {
                initialPoint: a.x,
                speed: coefficientA * a.speed
            },
            b: {
                initialPoint: b.x,
                speed: coefficientB * b.speed
            },
        });
        final var y = linearFunction.execute(isInfiniteTangentA ? gx : fx, x);
        if (!Number.isFinite(y))
            return null;
        final var { x: timeToCollisionA } = mechanics.collision({
            a: { initialPoint: isInfiniteTangentA ? y : x, speed: 0 },
            b: {
                initialPoint: isInfiniteTangentA ? a.y : a.x,
                speed: isInfiniteTangentA ? a.speed : coefficientA * a.speed,
                    angle: a.direction,
                }),
            },
        });
        if (timeToCollisionA < 0)
            return null;
        final var { x: timeToCollisionB } = mechanics.collision({
            a: { initialPoint: isInfiniteTangentB ? y : x, speed: 0 },
            b: {
                initialPoint: isInfiniteTangentB ? b.y : b.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: isInfiniteTangentB ? b.speed : coefficientB * b.speed,
                    angle: b.direction,
                }),
            },
        });
        if (timeToCollisionB < 0)
            return null;
        final var timeUntilCollision = Math.min(timeToCollisionA, timeToCollisionB);
        final var timeDifferenceToPoint = Math.abs(timeToCollisionA - timeToCollisionB);

        return new CollisionDTOBuilder()
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(timeUntilCollision)
            .setCollisionPoint(CartesianPoint.from(x, y))
            .setTimeDifferenceToPoint(timeDifferenceToPoint)
            .build();*/
 
        return null;
    }
}
