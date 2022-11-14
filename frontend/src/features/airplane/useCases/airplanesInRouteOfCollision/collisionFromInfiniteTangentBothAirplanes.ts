import { mechanics } from '../../../../core/mechanics';
import { planePoint } from '../../../../core/planePoint';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentBothAirplanes({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);
    const bAsCartesian = planePoint.toCartesian(b.planePoint);

    const { x: timeUntilCollision, y } = mechanics.collision({
        a: { initialPoint: aAsCartesian.y, speed: Number(a.vector.direction) === 90 ? Number(a.vector.speed) : -Number(a.vector.speed) },
        b: { initialPoint: bAsCartesian.y, speed: Number(b.vector.direction) === 90 ? Number(b.vector.speed) : -Number(b.vector.speed) },
    });
    if (!Number.isFinite(timeUntilCollision) || !Number.isFinite(y))
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: { x: aAsCartesian.x, y },
        timeDifferenceToPoint: 0,
    } as const;
}
