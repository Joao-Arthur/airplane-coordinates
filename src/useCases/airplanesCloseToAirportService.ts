import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';
import { airplanesInDistance } from './airplanesInDistance';

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
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesInDistance({ airplanes, maxDistance });
    if (closeAirplanes.length)
        for (const airplane of closeAirplanes)
            logger.info(
                `Avião #${airplane.id} a ${airplane.distanceFromAirport}m do aeroporto`,
            );
    else
        logger.info('Nenhum avião encontrado nessa distância');
}
