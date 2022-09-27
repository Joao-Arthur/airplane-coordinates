import { airplanesCloseToEachOtherBusiness } from './airplanesCloseToEachOtherBusiness';
import { airplanesCloseToEachOtherParamsType } from './airplanesCloseToEachOtherParams';

export function airplanesCloseToEachOtherService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToEachOtherParamsType) {
    logger.info('Calculando aviões mais próximos entre sí');
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = airplanesCloseToEachOtherBusiness({ airplanes, maxDistance });
    if (closeAirplanes.length)
        for (const airplane of closeAirplanes)
            logger.info(
                `Avião #${airplane.a} e #${airplane.b} a ${airplane.distance}m de distância entre si`,
            );
    else
        logger.info('Nenhum avião encontrado nessa distância.');
}
