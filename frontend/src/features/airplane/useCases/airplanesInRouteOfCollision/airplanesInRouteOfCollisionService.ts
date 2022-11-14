import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';
import { airplanesInRouteOfCollisionParamsType } from './airplanesInRouteOfCollisionParams';

export function airplanesInRouteOfCollisionService({
    logger,
    airplaneRepository,
    maxTime,
}: airplanesInRouteOfCollisionParamsType) {
    const airplanes = airplaneRepository.retrieve();
    const airplanesInRouteOfCollision = airplanesInRouteOfCollisionBusiness({ airplanes, maxTime });
    if (!airplanesInRouteOfCollision.length)
        return logger.info('Nenhum avião em rota de colisão nesse tempo');
    for (const airplane of airplanesInRouteOfCollision)
        logger.info(
            `Avião "${airplane.a}" e "${airplane.b}" vão passar a ${airplane.timeDifferenceToPoint}s de diferença no ponto (${airplane.collisionPoint.x}, ${airplane.collisionPoint.y}) daqui ${airplane.timeUntilCollision}s`,
        );
}
