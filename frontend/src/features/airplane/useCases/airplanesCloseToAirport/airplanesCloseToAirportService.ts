import { backend } from '../../../backend/backend';
import { airplanesCloseToAirportParamsType } from './airplanesCloseToAirportParams';

export async function airplanesCloseToAirportService({
    logger,
    airplaneRepository,
    maxDistance,
}: airplanesCloseToAirportParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const closeToAirport = await backend.pointsCloseToPoint({
        points: airplanes.map(airplane => ({
            id: airplane.id,
            point: airplane.planePoint,
        })),
        point: { x: '0', y: '0' },
        maxDistance,
    });
    if (!closeToAirport.points.length)
        return logger.info('Nenhum avião encontrado nessa distância');
    const pointsToLog = [...closeToAirport.points].reverse();
    for (const point of pointsToLog)
        logger.info(
            `Avião "${point.id}" a ${point.distanceFromPoint}km do aeroporto`,
        );
}
