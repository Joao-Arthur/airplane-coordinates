import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type translateIn = {
    readonly points: pointWithIdType[];
    readonly factor: backendCartesianPointType;
}

type translateOut = {
    readonly points: pointWithIdType[];
}

export function translate(params: translateIn): Promise<translateOut> {
    return postFetch('arithmetic/translate', params);
}
