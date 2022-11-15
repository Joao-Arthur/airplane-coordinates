import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type pointsCloseToPointIn = {
    readonly points: {
        id: string;
        point: planePointType;
    }[];
    readonly maxTime: string;
}

type pointsCloseToPointOut = {
    readonly points: {
        a: string;
        b: string;
        timeUntilCollision: string;
        collisionPoint: backendCartesianPointType;
        timeDifferenceToPoint: string;
    }[];
}

export function pointsInRouteOfCollision(params: pointsCloseToPointIn): Promise<pointsCloseToPointOut> {
    return postFetch('arithmetic/routeOfCollision', params);
}
