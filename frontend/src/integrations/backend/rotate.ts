import { rotate as backendRotate } from 'backend';
import { backendCartesianPointType } from './backendCartesianPoint';
import { backendPlanePointType } from './backendPlanePoint';

type paramsType = {
    point: backendPlanePointType;
    centerOfRotation: backendCartesianPointType;
    angle: string;
}

export function rotate({ point, centerOfRotation, angle }: paramsType): backendPlanePointType {
    return backendRotate({
        point,
        center_of_rotation: centerOfRotation,
        angle,
    });
}
