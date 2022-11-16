import { backend } from '../../../backend/backend';
import { airplanesCloseToEachOtherParamsType } from './airplanesCloseToEachOtherParams';

export async function airplanesCloseToEachOtherService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToEachOtherParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const closeToEachOther = await backend.pointsCloseToEachOther({
        points: airplanes.map(({ id, point }) => ({ id, point })),
        maxDistance,
    });
    if (!closeToEachOther.points.length)
        return logger.info('Nenhum avião encontrado nessa distância');
    const results = [...closeToEachOther.points].reverse();
    for (const result of results)
        logger.info(
            `Avião "${result.a}" e "${result.b}" a ${Number(result.distance).toFixed(2)}km de distância entre si`,
        );
}
