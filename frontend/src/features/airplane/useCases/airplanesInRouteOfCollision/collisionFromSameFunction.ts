import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { numberFns } from '../../../../core/numberFns';
import { planePoint } from '../../../../core/planePoint';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromSameFunction({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);
    const bAsCartesian = planePoint.toCartesian(b.planePoint);
    const fx = linearFunction.fromPoint({ point: aAsCartesian, angle: Number(a.vector.direction) });

    const coefficientA = Math.abs(Math.cos(Number(a.vector.direction) * Math.PI / 180));
    const coefficientB = Math.abs(Math.cos(Number(b.vector.direction) * Math.PI / 180));

    const { y: x } = mechanics.collision({
        a: {
            initialPoint: aAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * Number(a.vector.speed),
                angle: Number(a.vector.direction),
            }),
        },
        b: {
            initialPoint: bAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientB * Number(b.vector.speed),
                angle: Number(b.vector.direction),
            }),
        },
    });
    if (!Number.isFinite(x))
        return undefined;
    const y = linearFunction.execute(fx, x);

    const { x: timeToCollisionA } = mechanics.collision({
        a: { initialPoint: x, speed: 0 },
        b: {
            initialPoint: aAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * Number(a.vector.speed),
                angle: Number(a.vector.direction),
            }),
        },
    });
    if (timeToCollisionA < 0)
        return undefined;
    const { x: timeToCollisionB } = mechanics.collision({
        a: { initialPoint: x, speed: 0 },
        b: {
            initialPoint: bAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * Number(b.vector.speed),
                angle: Number(b.vector.direction),
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
            x: numberFns.fix(x),
            y: numberFns.fix(y),
        },
        timeDifferenceToPoint: numberFns.fix(timeDifferenceToPoint),
    } as const;
}
