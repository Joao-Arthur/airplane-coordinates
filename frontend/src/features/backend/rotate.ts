import { postFetch } from '../../core/httpRequest/httpRequest';
import { planePointType } from '../../core/planePoint/planePointType';

type rotateIn = {
    readonly point: planePointType;
    readonly centerOfRotation: {
        x: string;
        y: string;
    }
    readonly angle: string;
}

type rotateOut = {
    readonly point: planePointType;
}

export function rotate(params: rotateIn): Promise<rotateOut> {
    return postFetch('arithmetic/rotate', params);
}
