import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type pointsCloseToPointIn = {
    readonly points: {
        id: string;
        point: planePointType;
    }[];
    readonly point: {
        readonly x: string;
        readonly y: string;
    };
    readonly maxDistance: string;
}

type pointsCloseToPointOut = {
    readonly points: {
        id: string;
        distanceFromPoint: string;
    }[];
}

export function pointsCloseToPoint(params: pointsCloseToPointIn): Promise<pointsCloseToPointOut> {
    return postFetch('arithmetic/closeToPoint', params);
}
