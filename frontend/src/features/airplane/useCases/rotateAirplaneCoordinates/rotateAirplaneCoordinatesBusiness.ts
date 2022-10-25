import { rotate } from '../../../backend/useCases/rotate';
import { airplaneCoordinatesType } from '../../models/savedAirplane';
import { backendToSaved } from '../backendToSaved';
import { savedToBackend } from '../savedToBackend';

type paramsType = {
    readonly coordinates: airplaneCoordinatesType;
    readonly centerOfRotation: {
        readonly x: string;
        readonly y: string;
    };
    readonly angle: number;
}

export function rotateAirplaneCoordinatesBusiness({
    coordinates,
    centerOfRotation,
    angle,
}: paramsType): airplaneCoordinatesType {
    const point = savedToBackend(coordinates);
    const updatedPoint = rotate({
        point,
        center_of_rotation: centerOfRotation,
        angle: String(angle),
    });
    const newValue = backendToSaved(updatedPoint);
    return newValue;
}
