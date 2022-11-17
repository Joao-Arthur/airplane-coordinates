import { numberFns } from '../../../../core/numberFns';
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
    for (const result of results) {
        const a = result.a;
        const b = result.b;
        const distance = numberFns.limitDecimals(Number(result.distance));

        logger.info(`Aviões "${a}" e "${b}": ${distance}km de distância entre si`);
    }
}
