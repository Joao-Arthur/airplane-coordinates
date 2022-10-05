import { standardize } from '../standardize';
import { airplanesCloseToEachOtherBusiness } from './airplanesCloseToEachOtherBusiness';
import { airplanesCloseToEachOtherParamsType } from './airplanesCloseToEachOtherParams';

export function airplanesCloseToEachOtherService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToEachOtherParamsType) {
    const airplanes = airplaneRepository
        .retrieve()
        .map(standardize);
    const closeAirplanes = airplanesCloseToEachOtherBusiness({ airplanes, maxDistance });
    if (!closeAirplanes.length) {
        logger.info('Nenhum avião encontrado nessa distância.');
        return;
    }
    for (const airplane of closeAirplanes)
        logger.info(
            `Avião "${airplane.a}" e "${airplane.b}" a ${airplane.distance}m de distância entre si`,
        );
}
