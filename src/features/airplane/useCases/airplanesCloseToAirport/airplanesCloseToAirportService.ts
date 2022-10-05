import { savedAirplaneToDTO } from '../savedAirplaneToDTO';
import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';
import { airplanesCloseToAirportParamsType } from './airplanesCloseToAirportParams';

export function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToAirportParamsType) {
    const airplanes = airplaneRepository
        .retrieve()
        .map(savedAirplaneToDTO);
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
