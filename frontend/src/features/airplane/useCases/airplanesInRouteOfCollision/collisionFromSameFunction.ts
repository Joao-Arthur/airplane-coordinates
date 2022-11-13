import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { numberFns } from '../../../../core/numberFns';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromSameFunction({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.vector.direction });

    const coefficientA = Math.abs(Math.cos(a.vector.direction * Math.PI / 180));
    const coefficientB = Math.abs(Math.cos(b.vector.direction * Math.PI / 180));

    const { y: x } = mechanics.collision({
        a: {
            initialPoint: a.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * a.vector.speed,
                angle: a.vector.direction,
            }),
        },
        b: {
            initialPoint: b.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientB * b.vector.speed,
                angle: b.vector.direction,
            }),
        },
    });
    if (!Number.isFinite(x))
        return undefined;
    const y = linearFunction.execute(fx, x);

    const { x: timeToCollisionA } = mechanics.collision({
        a: { initialPoint: x, speed: 0 },
        b: {
            initialPoint: a.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * a.vector.speed,
                angle: a.vector.direction,
            }),
        },
    });
    if (timeToCollisionA < 0)
        return undefined;
    const { x: timeToCollisionB } = mechanics.collision({
        a: { initialPoint: x, speed: 0 },
        b: {
            initialPoint: b.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA * b.vector.speed,
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
