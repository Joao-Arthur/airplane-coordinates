import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type pointsCloseToPointIn = {
    readonly points: pointWithIdType[];
    readonly point: backendCartesianPointType;
    readonly maxDistance: string;
}

type pointsCloseToPointOut = {
    readonly points: {
        readonly id: string;
        readonly distanceFromPoint: string;
    }[];
}

export function pointsCloseToPoint(params: pointsCloseToPointIn): Promise<pointsCloseToPointOut> {
    return postFetch('arithmetic/closeToPoint', params);
}
