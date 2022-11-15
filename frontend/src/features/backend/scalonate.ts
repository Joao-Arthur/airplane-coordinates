import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type scalonateIn = {
    readonly point: planePointType;
    readonly factor: {
        x: string;
        y: string;
    };
}

type scalonateOut = {
    readonly point: planePointType;
}

export function scalonate(params: scalonateIn): Promise<scalonateOut> {
    return postFetch('arithmetic/scalonate', params);
}
