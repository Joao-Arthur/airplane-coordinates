import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    maxDistance: number;
};

export function airplanesCloseToAirport({
    logger,
    airplaneRepository,
    maxDistance,
}: paramsType) {
    logger.info('Calculando aviões mais próximos do aeroporto');
}
