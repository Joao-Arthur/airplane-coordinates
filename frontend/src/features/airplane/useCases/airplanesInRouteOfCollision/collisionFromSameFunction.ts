import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromSameFunction({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({
        point: { x: a.x, y: a.y },
        angle: a.direction,
    });
    const coefficientA = Math.cos(a.direction * Math.PI / 180);
    const coefficientB = Math.cos(b.direction * Math.PI / 180);

    const { x: timeUntilCollision, y: x } = mechanics.collision({
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

    if (!Number.isFinite(timeUntilCollision) || !Number.isFinite(y))
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: { x, y },
        timeDifferenceToPoint: 0,
    } as const;

}
