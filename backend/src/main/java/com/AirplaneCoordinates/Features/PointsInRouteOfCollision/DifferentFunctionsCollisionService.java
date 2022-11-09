package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;

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
/*
    const fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
    const gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
    const intersectionPoint = linearFunction.findInsersectionPoint({
        fx,
        gx,
    });
    if (!intersectionPoint)
        return undefined;
    const coefficientA = Math.abs(Math.cos(a.direction * Math.PI / 180));
    const coefficientB = Math.abs(Math.cos(b.direction * Math.PI / 180));

    const { y: x } = mechanics.collision({
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
    const y = linearFunction.execute(fx, x);
    if (!Number.isFinite(y))
        return undefined;
    const { x: timeToCollisionA } = mechanics.collision({
        a: { initialPoint: intersectionPoint.x, speed: 0 },
        b: {
            initialPoint: a.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * a.speed,
                angle: a.direction,
            }),
        },
    });
    if (timeToCollisionA < 0)
        return undefined;
    const { x: timeToCollisionB } = mechanics.collision({
        a: { initialPoint: intersectionPoint.x, speed: 0 },
        b: {
            initialPoint: b.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * b.speed,
                angle: b.direction,
            }),
        },
    });
    if (timeToCollisionB < 0)
        return undefined;
    const timeUntilCollision = Math.min(timeToCollisionA, timeToCollisionB);
    const timeDifferenceToPoint = Math.abs(timeToCollisionA - timeToCollisionB);

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
 */



        return null;
    }
}