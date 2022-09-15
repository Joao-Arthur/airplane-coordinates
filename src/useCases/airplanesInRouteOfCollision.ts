import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    airplaneRepository: airplaneRepositoryType;
    maxTime: number;
    logger: loggerType;
};

export type airplanesInRouteOfCollision = (
    params: paramsType
) => void;
