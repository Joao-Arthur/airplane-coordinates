import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type translateIn = {
    readonly point: planePointType;
    readonly factor: {
        x: string;
        y: string;
    };
}

type translateOut = {
    readonly point: planePointType;
}

export function translate(params: translateIn): Promise<translateOut> {
    return postFetch('arithmetic/translate', params);
}
