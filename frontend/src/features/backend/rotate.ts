import { backendCartesianPointType } from '../../core/cartesianPlane/backendCartesianPoint';
import { postFetch } from '../../core/httpRequest/httpRequest';
import { pointWithIdType } from './pointWithId';

type rotateIn = {
    readonly points: pointWithIdType[];
    readonly centerOfRotation: backendCartesianPointType;
    readonly angle: string;
}

type rotateOut = {
    readonly points: pointWithIdType[];
}

export function rotate(params: rotateIn): Promise<rotateOut> {
    return postFetch('arithmetic/rotate', params);
}
