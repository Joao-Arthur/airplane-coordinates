import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type pointsCloseToPointIn = {
    readonly points: pointWithIdType[];
    readonly maxTime: string;
}

type pointsCloseToPointOut = {
    readonly points: {
        readonly a: string;
        readonly b: string;
        readonly timeUntilCollision: string;
        readonly collisionPoint: backendCartesianPointType;
        readonly timeDifferenceToPoint: string;
    }[];
}

export function pointsInRouteOfCollision(params: pointsCloseToPointIn): Promise<pointsCloseToPointOut> {
    return postFetch('arithmetic/routeOfCollision', params);
}
