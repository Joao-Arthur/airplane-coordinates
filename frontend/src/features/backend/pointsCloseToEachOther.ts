import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type pointsCloseToEachOtherIn = {
    readonly points: pointWithIdType[];
    readonly maxDistance: string;
}

type pointsCloseToEachOtherOut = {
    readonly points: {
        a: string;
        b: string;
        distance: string;
    }[];
}

export function pointsCloseToEachOther(params: pointsCloseToEachOtherIn): Promise<pointsCloseToEachOtherOut> {
    return postFetch('arithmetic/closeToEachOther', params);
}
