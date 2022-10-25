import { translate } from '../../../backend/useCases/translate';
import { airplaneCoordinatesType } from '../../models/savedAirplane';
import { backendToSaved } from '../backendToSaved';
import { savedToBackend } from '../savedToBackend';

type paramsType = {
    readonly coordinates: airplaneCoordinatesType;
    readonly x: number;
    readonly y: number;
}

export function translateAirplaneCoordinatesBusiness({ coordinates, x, y }: paramsType): airplaneCoordinatesType {
    const point = savedToBackend(coordinates);
    const updatedPoint = translate({
        point,
        factor: {
            x: String(x),
            y: String(y),
        },
    });
    const newValue = backendToSaved(updatedPoint);
    return newValue;
} 
