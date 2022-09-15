import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    selectedIds: any[];
    angle: number;
    centerOfRotationX: number;
    centerOfRotationY: number;
};

export type rotateAirplaneCoordinates = (
    params: paramsType
) => void;
