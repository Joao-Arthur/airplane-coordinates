import { numberFns } from '../../../../core/numberFns';
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
    for (const result of results) {
        const id = result.id;
        const distanceFromPoint = numberFns.limitDecimals(Number(result.distanceFromPoint));

        logger.info(`Avião "${id}": ${distanceFromPoint}km do aeroporto`);
    }
}
