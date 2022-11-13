import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromSamePosition({ a, b }: paramsType) {
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision: 0,
        collisionPoint: a.planePoint,
        timeDifferenceToPoint: 0,
    } as const;
}
