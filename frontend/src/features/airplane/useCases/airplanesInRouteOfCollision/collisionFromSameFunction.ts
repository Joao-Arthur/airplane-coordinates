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
    const fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });

    const coefficientA = Math.abs(Math.cos(a.direction * Math.PI / 180));
    const coefficientB = Math.abs(Math.cos(b.direction * Math.PI / 180));

    const { y: x } = mechanics.collision({
        a: {
            initialPoint: a.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientA,
                angle: a.direction,
            }),
        },
        b: {
            initialPoint: b.x,
            speed: trigonometry.getValueInEachQuadrant({
                value: coefficientB,
                angle: b.direction,
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
                value: coefficientA * a.speed,
                angle: a.direction,
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
                value: coefficientA * b.speed,
                angle: b.direction,
            }),
        },
    });
    if (timeToCollisionB < 0)
        return undefined;
    const timeUntilCollision = Math.min(timeToCollisionA, timeToCollisionB);
    const timeDifferenceToPoint = timeToCollisionA - timeToCollisionB;

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
