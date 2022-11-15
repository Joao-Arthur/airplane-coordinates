import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type pointsCloseToEachOtherIn = {
    readonly points: {
        id: string;
        point: planePointType;
    }[];
    readonly maxDistance: string;
}

type pointsCloseToEachOtherOut = {
    readonly points: {
        a: string;
        b: string;
        distanceFromPoint: string;
    }[];
}

export function pointsCloseToEachOther(params: pointsCloseToEachOtherIn): Promise<pointsCloseToEachOtherOut> {
    return postFetch('arithmetic/closeToEachOther', params);
}
