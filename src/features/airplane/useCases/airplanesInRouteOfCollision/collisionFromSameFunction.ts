import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

function getSignInEachQuadrant(speed: number, angle: number) {
    if (angle < 90)
        return speed;
    if (angle < 180)
        return -speed;
    if (angle < 270)
        return -speed;
    return speed;
}

export function collisionFromSameFunction({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({
        point: { x: a.x, y: a.y },
        angle: a.direction,
    });
    const coefficientA = Math.cos(a.direction * Math.PI / 180);
    const coefficientB = Math.cos(a.direction * Math.PI / 180);

    const { x: timeUntilCollision, y: x } = mechanics.collision({
        a: { initialPoint: a.x, speed: getSignInEachQuadrant(coefficientA * a.speed, a.direction) },
        b: { initialPoint: b.x, speed: getSignInEachQuadrant(coefficientB * b.speed, b.direction) },
    });

    const y = linearFunction.execute(fx, x);

    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: { x, y },
        timeDifferenceToPoint: 0,
    } as const;

}
