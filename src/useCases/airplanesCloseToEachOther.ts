import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    maxDistance: number;
};

export type airplanesCloseToEachOther = (
    params: paramsType
) => void;
