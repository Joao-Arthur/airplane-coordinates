import { mechanics } from '../../../../core/mechanics';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentBothAirplanes({ a, b }: paramsType) {
    const { x: timeUntilCollision, y } = mechanics.collision({
        a: { initialPoint: a.y, speed: a.direction === 90 ? a.speed : -a.speed },
        b: { initialPoint: b.y, speed: b.direction === 90 ? b.speed : -b.speed },
    });
    if (!Number.isFinite(timeUntilCollision) || !Number.isFinite(y))
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: { x: a.x, y },
        timeDifferenceToPoint: 0,
    } as const;
}
