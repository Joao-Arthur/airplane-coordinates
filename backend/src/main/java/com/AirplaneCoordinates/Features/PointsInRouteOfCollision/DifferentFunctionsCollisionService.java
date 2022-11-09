package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;
import com.AirplaneCoordinates.Core.LinearFunction;
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
        final var fx = LinearFunction.from(
            this.pointA.point.toCartesian(),
            this.pointA.vector.direction
        );
        final var gx = LinearFunction.from(
            this.pointB.point.toCartesian(),
            this.pointB.vector.direction
        );
        final var intersectionPoint = LinearFunction
            .intersect(fx, gx);
        final var coefficientA = new Deg(this.pointA.vector.direction)
            .toRad()
            .value
            .cos();
        final var coefficientB = new Deg(this.pointB.vector.direction)
            .toRad()
            .value
            .cos();

        final var { y: x } = mechanics.collision({
            a: {
                initialPoint: a.x,
                speed: coefficientA * a.speed
                    value: ,
                    angle: a.direction,
                }),
            },
            b: {
                initialPoint: b.x,
                speed: 
                    value: coefficientB * b.speed,
                    angle: b.direction,
                }),
            },
        });
        final var y = linearFunction.execute(fx, x);
        if (!Number.isFinite(y))
            return null;
        final var { x: timeToCollisionA } = mechanics.collision({
            a: { initialPoint: intersectionPoint.x, speed: 0 },
            b: {
                initialPoint: a.x,
                speed: coefficientA * a.speed
            },
        });
        if (timeToCollisionA < 0)
            return null;
        final var { x: timeToCollisionB } = mechanics.collision({
            a: { initialPoint: intersectionPoint.x, speed: 0 },
            b: {
                initialPoint: b.x,
                speed: coefficientA * b.speed,
            },
        });
        if (timeToCollisionB < 0)
            return null;
        final var timeUntilCollision = Math.min(timeToCollisionA, timeToCollisionB);
        final var timeDifferenceToPoint = Math.abs(timeToCollisionA - timeToCollisionB);

        return {
            a: a.id,
            b: b.id,
            timeUntilCollision: numberFns.fix(timeUntilCollision),
            collisionPoint: {
                x: numberFns.fix(intersectionPoint.x),
                y: numberFns.fix(intersectionPoint.y),
            },
            timeDifferenceToPoint: numberFns.fix(timeDifferenceToPoint),
        };

        return null;
    }
}