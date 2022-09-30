import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';
import { airplanesCloseToAirportParamsType } from './airplanesCloseToAirportParams';

export function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToAirportParamsType) {
    logger.info('Calculando aviões mais próximos do aeroporto');
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesCloseToAirportBusiness({ airplanes, maxDistance });
    if (!closeAirplanes.length) {
        logger.info('Nenhum avião encontrado nessa distância');
        return;
    }
    for (const airplane of closeAirplanes)
        logger.info(
            `Avião "${airplane.id}" a ${airplane.distanceFromAirport}m do aeroporto`,
        );
}
