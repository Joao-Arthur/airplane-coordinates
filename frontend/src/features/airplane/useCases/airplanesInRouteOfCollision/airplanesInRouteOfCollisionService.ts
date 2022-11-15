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
            `Avião "${airplane.a}" e "${airplane.b}" vão passar a ${airplane.timeDifferenceToPoint}h de diferença no ponto (${airplane.collisionPoint.x}, ${airplane.collisionPoint.y}) daqui ${airplane.timeUntilCollision}s`,
        );
}
