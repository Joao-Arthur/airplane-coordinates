import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { loggerType } from '../../ports/logger';
import { airplanesInDistance } from './airplanesInDistance';

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
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesInDistance({ airplanes, maxDistance });
    if (closeAirplanes.length)
        for (const airplane of closeAirplanes)
            logger.info(
                `Avião #${airplane.a} e #${airplane.b} a ${airplane.distance}m de distância entre si`,
            );
    else
        logger.info('Nenhum avião encontrado nessa distância.');
}
