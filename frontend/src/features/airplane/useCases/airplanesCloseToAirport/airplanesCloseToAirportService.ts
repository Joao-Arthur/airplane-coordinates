import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';
import { airplanesCloseToAirportParamsType } from './airplanesCloseToAirportParams';

export function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToAirportParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesCloseToAirportBusiness({ airplanes, maxDistance });
    if (!closeAirplanes.length)
        return logger.info('Nenhum avião encontrado nessa distância');
    for (const airplane of closeAirplanes)
        logger.info(
            `Avião "${airplane.id}" a ${airplane.distanceFromAirport}m do aeroporto`,
        );
}
