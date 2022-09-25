import { airplaneRepositoryType } from '../../models/airplaneRepository';
import { loggerType } from '../../models/logger';
import { airplanesCloseToEachOtherBusiness } from './airplanesCloseToEachOtherBusiness';

type paramsType = {
    readonly logger: loggerType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly maxDistance: number;
};

export function airplanesCloseToEachOtherService({
    logger,
    airplaneRepository,
    maxDistance,
}: paramsType) {
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
