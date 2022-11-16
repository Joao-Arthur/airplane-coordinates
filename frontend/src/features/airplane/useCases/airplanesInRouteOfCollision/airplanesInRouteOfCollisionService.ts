import { backend } from '../../../backend/backend';
import { airplanesInRouteOfCollisionParamsType } from './airplanesInRouteOfCollisionParams';

export async function airplanesInRouteOfCollisionService({
    logger,
    airplaneRepository,
    maxTime,
}: airplanesInRouteOfCollisionParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const inRouteOfCollision = await backend.pointsInRouteOfCollision({
        points: airplanes.map(({ id, point, vector }) => ({ id, point, vector })),
        maxTime,
    });
    if (!inRouteOfCollision.points.length)
        return logger.info('Nenhum avião em rota de colisão nesse tempo');
    const pointsToLog = [...inRouteOfCollision.points].reverse();
    for (const airplane of pointsToLog)
        logger.info(
            `Avião "${airplane.a}" e "${airplane.b}" ` +
            `vão passar a ${Number(airplane.timeDifferenceToPoint).toFixed(2)}h de diferença ` +
            `no ponto (${Number(airplane.collisionPoint.x).toFixed(2)}, ${Number(airplane.collisionPoint.y).toFixed(2)}) ` +
            `daqui ${Number(airplane.timeUntilCollision).toFixed(2)}h`,
        );
}
