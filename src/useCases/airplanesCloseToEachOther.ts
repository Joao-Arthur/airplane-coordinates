import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    maxDistance: number;
};

export function airplanesCloseToEachOther({
    logger,
    airplaneRepository,
    maxDistance,
}: paramsType) {
    logger.info('Calculando aviões mais próximos entre sí');
}
