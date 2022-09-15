import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    maxTime: number;
};

export type airplanesInRouteOfCollision = (
    params: paramsType
) => void;
