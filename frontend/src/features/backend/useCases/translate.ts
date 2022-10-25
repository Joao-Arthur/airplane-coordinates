import { translate as backendTranslate } from 'backend';
import { backendCartesianPointType } from '../models/backendCartesianPoint';
import { backendPlanePointType } from '../models/backendPlanePoint';

type paramsType = {
    readonly point: backendPlanePointType;
    readonly factor: backendCartesianPointType;
}

export function translate({ point, factor }: paramsType): backendPlanePointType {
    return backendTranslate({ point, factor });
}
