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

export function collisionFromInfiniteTangentInOneAirplane({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);
    const bAsCartesian = planePoint.toCartesian(b.planePoint);
    const fx = linearFunction.fromPoint({ point: aAsCartesian, angle: Number(a.vector.direction) });
    const gx = linearFunction.fromPoint({ point: bAsCartesian, angle: Number(b.vector.direction) });
    const coefficientA = [90, 270].includes(Number(a.vector.direction)) ? 0 : Math.abs(Math.cos(Number(a.vector.direction) * Math.PI / 180));
    const coefficientB = [90, 270].includes(Number(b.vector.direction)) ? 0 : Math.abs(Math.cos(Number(b.vector.direction) * Math.PI / 180));
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
    const y = linearFunction.execute([90, 270].includes(Number(a.vector.direction)) ? gx : fx, x);
    if (!Number.isFinite(y))
        return undefined;
    const { x: timeToCollisionA } = mechanics.collision({
        a: { initialPoint: [90, 270].includes(Number(a.vector.direction)) ? y : x, speed: 0 },
        b: {
            initialPoint: [90, 270].includes(Number(a.vector.direction)) ? aAsCartesian.y : aAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: [90, 270].includes(Number(a.vector.direction)) ? Number(a.vector.speed) : coefficientA * Number(a.vector.speed),
                angle: Number(a.vector.direction),
            }),
        },
    });
    if (timeToCollisionA < 0)
        return undefined;
    const { x: timeToCollisionB } = mechanics.collision({
        a: { initialPoint: [90, 270].includes(Number(b.vector.direction)) ? y : x, speed: 0 },
        b: {
            initialPoint: [90, 270].includes(Number(b.vector.direction)) ? bAsCartesian.y : bAsCartesian.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: [90, 270].includes(Number(b.vector.direction)) ? Number(b.vector.speed) : coefficientB * Number(b.vector.speed),
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
