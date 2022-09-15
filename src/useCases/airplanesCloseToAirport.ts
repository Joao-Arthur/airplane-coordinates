import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    airplaneRepository: airplaneRepositoryType;
    maxDistance: number;
    logger: loggerType;
};

export type airplanesCloseToAirport = (
    params: paramsType
) => void;
