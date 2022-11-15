import { backend } from '../../../backend/backend';
import { airplanesCloseToEachOtherParamsType } from './airplanesCloseToEachOtherParams';

export async function airplanesCloseToEachOtherService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToEachOtherParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const closeAirplanes = await backend.pointsCloseToEachOther({
        points: airplanes.map(airplane => ({
            id: airplane.id,
            point: airplane.planePoint,
        })),
        maxDistance,
    });
    if (!closeAirplanes.points.length)
        return logger.info('Nenhum avião encontrado nessa distância');
    const pointsToLog = [...closeAirplanes.points].reverse();
    for (const point of pointsToLog)
        logger.info(
            `Avião "${point.a}" e "${point.b}" a ${point.distanceFromPoint}m de distância entre si`,
        );
}
