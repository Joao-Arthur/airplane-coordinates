import { translate } from './translate';
import { scalonate } from './scalonate';
import { rotate } from './rotate';
import { pointsCloseToEachOther } from './pointsCloseToEachOther';
import { pointsCloseToPoint } from './pointsCloseToPoint';
import { pointsInRouteOfCollision } from './pointsInRouteOfCollision';

export const backend = {
    translate,
    scalonate,
    rotate,
    pointsCloseToEachOther,
    pointsCloseToPoint,
    pointsInRouteOfCollision,
} as const;
