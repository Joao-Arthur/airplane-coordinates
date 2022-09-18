import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

type paramsType = {
    readonly logger: loggerType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly maxTime: number;
};

export function airplanesInRouteOfCollision({
    logger,
    airplaneRepository,
    maxTime,
}: paramsType) {
    logger.info('Calculando aviões em rota de colisão');
}
