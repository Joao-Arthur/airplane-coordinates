import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    logger: loggerType;
    airplaneRepository: airplaneRepositoryType;
    maxTime: number;
};

export function airplanesInRouteOfCollision({
    logger,
    airplaneRepository,
    maxTime,
}: paramsType) {
    logger.info('Calculando aviões em rota de colisão');
}
