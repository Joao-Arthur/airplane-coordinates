import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type scalonateIn = {
    readonly points: pointWithIdType[];
    readonly factor: backendCartesianPointType;
}

type scalonateOut = {
    readonly points: pointWithIdType[];
}

export function scalonate(params: scalonateIn): Promise<scalonateOut> {
    return postFetch('arithmetic/scalonate', params);
}
