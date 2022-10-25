import { translate as backendTranslate } from 'backend';
import { backendCartesianPointType } from './backendCartesianPoint';
import { backendPlanePointType } from './backendPlanePoint';

type paramsType = {
    point: backendPlanePointType;
    factor: backendCartesianPointType;
}

export function translate({ point, factor }: paramsType): backendPlanePointType {
    return backendTranslate({ point, factor });
}
