import { cartesianPlane } from '../../../../core/cartesianPlane';
import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { numberFns } from '../../../../core/numberFns';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromDifferentFunction({ a, b }: paramsType) {
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
    if (timeUntilCollision < 0)
        return undefined;
    if (!Number.isFinite(timeUntilCollision) || !Number.isFinite(y))
        return undefined;
    const aDistance = cartesianPlane.distance({ x: a.x, y: a.y }, intersectionPoint);
    const aTimeTo = mechanics.timeToPoint({ speed: a.speed, distance: aDistance });
    const bDistance = cartesianPlane.distance({ x: b.x, y: b.y }, intersectionPoint);
    const bTimeTo = mechanics.timeToPoint({ speed: b.speed, distance: bDistance });
    const timeDifferenceToPoint = aTimeTo - bTimeTo;

    return {
        a: a.id,
        b: b.id,
        timeUntilCollision: numberFns.fix(timeUntilCollision),
        collisionPoint: {
            x: numberFns.fix(intersectionPoint.x),
            y: numberFns.fix(intersectionPoint.y),
        },
        timeDifferenceToPoint: numberFns.fix(timeDifferenceToPoint),
    } as const;
}
