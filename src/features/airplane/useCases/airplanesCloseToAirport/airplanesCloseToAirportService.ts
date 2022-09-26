import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';

type paramsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly maxDistance: number;
};

export function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: paramsType) {
    logger.info('Calculando aviões mais próximos do aeroporto');
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesCloseToAirportBusiness({ airplanes, maxDistance });
    if (closeAirplanes.length)
        for (const airplane of closeAirplanes)
            logger.info(
                `Avião #${airplane.id} a ${airplane.distanceFromAirport}m do aeroporto`,
            );
    else
        logger.info('Nenhum avião encontrado nessa distância');
}
