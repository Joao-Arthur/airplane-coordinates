import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';
import { airplanesInRouteOfCollisionParamsType } from './airplanesInRouteOfCollisionParams';

export function airplanesInRouteOfCollisionService({
    logger,
    airplaneRepository,
    maxTime,
}: airplanesInRouteOfCollisionParamsType) {
    logger.info('Calculando aviões em rota de colisão');
    const airplanes = airplaneRepository.retrieve();
    const airplanesInRouteOfCollision = airplanesInRouteOfCollisionBusiness({ airplanes, maxTime });
    if (airplanesInRouteOfCollision.length)
        for (const airplane of airplanesInRouteOfCollision)
            logger.info(
                `Avião #${airplane.a} e #${airplane.b} vão passar a ${airplane.timeDifferenceToPoint}s de diferença no mesmo lugar daqui  ${airplane.timeUntilCollision}s`,
            );
    else
        logger.info('Nenhum avião em rota de colisão nesse tempo');
}
