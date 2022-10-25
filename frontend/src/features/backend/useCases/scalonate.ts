import { scalonate as backendScalonate } from 'backend';
import { backendCartesianPointType } from '../models/backendCartesianPoint';
import { backendPlanePointType } from '../models/backendPlanePoint';

type paramsType = {
    readonly point: backendPlanePointType;
    readonly factor: backendCartesianPointType;
}

export function scalonate({ point, factor }: paramsType) {
    return backendScalonate({ point, factor });
}
