import { backend } from '../../../backend/backend';
import { airplanesCloseToAirportParamsType } from './airplanesCloseToAirportParams';

export async function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToAirportParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const closeToAirport = await backend.pointsCloseToPoint({
        points: airplanes.map(({ id, point }) => ({ id, point })),
        point: { x: '0', y: '0' },
        maxDistance,
    });
    if (!closeToAirport.points.length)
        return logger.info('Nenhum avião encontrado nessa distância');
    const results = [...closeToAirport.points].reverse();
    for (const result of results)
        logger.info(
            `Avião "${result.id}" a ${Number(result.distanceFromPoint).toFixed(2)}km do aeroporto`,
        );
}
