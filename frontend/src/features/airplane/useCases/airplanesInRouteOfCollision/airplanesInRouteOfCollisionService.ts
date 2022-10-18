import { savedAirplaneToDTO } from '../savedAirplaneToDTO';
import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';
import { airplanesInRouteOfCollisionParamsType } from './airplanesInRouteOfCollisionParams';

export function airplanesInRouteOfCollisionService({
    logger,
    airplaneRepository,
    maxTime,
}: airplanesInRouteOfCollisionParamsType) {
    const airplanes = airplaneRepository
        .retrieve()
        .map(savedAirplaneToDTO);
    const airplanesInRouteOfCollision = airplanesInRouteOfCollisionBusiness({ airplanes, maxTime });
    if (!airplanesInRouteOfCollision.length) {
        logger.info('Nenhum avião em rota de colisão nesse tempo');
        return;
    }
    for (const airplane of airplanesInRouteOfCollision)
        logger.info(
            `Avião "${airplane.a}" e "${airplane.b}" vão passar a ${airplane.timeDifferenceToPoint}s de diferença no ponto (${airplane.collisionPoint.x}, ${airplane.collisionPoint.y}) daqui ${airplane.timeUntilCollision}s`,
        );
}