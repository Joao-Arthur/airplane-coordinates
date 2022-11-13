import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { numberFns } from '../../../../core/numberFns';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentInOneAirplane({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({ point: a.planePoint, angle: a.vector.direction });
    const gx = linearFunction.fromPoint({ point: b.planePoint, angle: b.vector.direction });
    const coefficientA = [90, 270].includes(a.vector.direction) ? 0 : Math.abs(Math.cos(a.vector.direction * Math.PI / 180));
    const coefficientB = [90, 270].includes(b.vector.direction) ? 0 : Math.abs(Math.cos(b.vector.direction * Math.PI / 180));
    const { y: x } = mechanics.collision({
        a: {
            initialPoint: a.planePoint.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * a.vector.speed,
                angle: a.vector.direction,
            }),
        },
        b: {
            initialPoint: b.planePoint.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientB * b.vector.speed,
                angle: b.vector.direction,
            }),
        },
    });
    const y = linearFunction.execute([90, 270].includes(a.vector.direction) ? gx : fx, x);
    if (!Number.isFinite(y))
        return undefined;
    const { x: timeToCollisionA } = mechanics.collision({
        a: { initialPoint: [90, 270].includes(a.vector.direction) ? y : x, speed: 0 },
        b: {
            initialPoint: [90, 270].includes(a.vector.direction) ? a.planePoint.y : a.planePoint.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: [90, 270].includes(a.vector.direction) ? a.vector.speed : coefficientA * a.vector.speed,
                angle: a.vector.direction,
            }),
        },
    });
    if (timeToCollisionA < 0)
        return undefined;
    const { x: timeToCollisionB } = mechanics.collision({
        a: { initialPoint: [90, 270].includes(b.vector.direction) ? y : x, speed: 0 },
        b: {
            initialPoint: [90, 270].includes(b.vector.direction) ? b.planePoint.y : b.planePoint.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: [90, 270].includes(b.vector.direction) ? b.vector.speed : coefficientB * b.vector.speed,
                angle: b.vector.direction,
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
