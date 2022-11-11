package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class SameFunctionCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public SameFunctionCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() { 

        /*final var fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });

        final var coefficientA = Math.abs(Math.cos(a.direction * Math.PI / 180));
        final var coefficientB = Math.abs(Math.cos(b.direction * Math.PI / 180));

        final var { y: x } = mechanics.collision({
            a: {
                initialPoint: a.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientA * a.speed,
                    angle: a.direction,
                }),
            },
            b: {
                initialPoint: b.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientB * b.speed,
                    angle: b.direction,
                }),
            },
        });
        if (!Number.isFinite(x))
            return null;
        final var y = linearFunction.execute(fx, x);

        final var { x: timeToCollisionA } = mechanics.collision({
            a: { initialPoint: x, speed: 0 },
            b: {
                initialPoint: a.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientA * a.speed,
                    angle: a.direction,
                }),
            },
        });
        if (timeToCollisionA < 0)
            return null;
        final var { x: timeToCollisionB } = mechanics.collision({
            a: { initialPoint: x, speed: 0 },
            b: {
                initialPoint: b.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientA * b.speed,
                    angle: b.direction,
                }),
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
                x: numberFns.fix(x),
                y: numberFns.fix(y),
            },
            timeDifferenceToPoint: numberFns.fix(timeDifferenceToPoint),
        };*/

        return null;
    }
}
