import { rotate as backendRotate } from 'backend';
import { backendCartesianPointType } from '../models/backendCartesianPoint';
import { backendPlanePointType } from '../models/backendPlanePoint';

type paramsType = {
    readonly point: backendPlanePointType;
    readonly center_of_rotation: backendCartesianPointType;
    readonly angle: string;
}

export function rotate({ point, center_of_rotation, angle }: paramsType): backendPlanePointType {
    return backendRotate({ point, center_of_rotation, angle });
}
