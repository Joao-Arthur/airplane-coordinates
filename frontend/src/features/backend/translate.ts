import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type translateIn = {
    readonly point: planePointType;
    readonly factor: backendCartesianPointType;
}

type translateOut = {
    readonly point: planePointType;
}

export function translate(params: translateIn): Promise<translateOut> {
    return postFetch('arithmetic/translate', params);
}
