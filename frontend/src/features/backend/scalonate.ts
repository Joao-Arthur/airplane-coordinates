import { scalonate as backendScalonate } from 'backend';
import { backendCartesianPointType } from './backendCartesianPoint';
import { backendPlanePointType } from './backendPlanePoint';

type paramsType = {
    point: backendPlanePointType;
    factor: backendCartesianPointType;
}

export function scalonate({ point, factor }: paramsType) {
    return backendScalonate({ point, factor });
}
