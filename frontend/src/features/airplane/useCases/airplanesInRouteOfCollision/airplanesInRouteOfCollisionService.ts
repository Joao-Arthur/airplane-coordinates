import { numberFns } from '../../../../core/numberFns';
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
    const results = [...inRouteOfCollision.points].reverse();
    for (const result of results) {
        const a = result.a;
        const b = result.b;
        const x = numberFns.limitDecimals(Number(result.collisionPoint.x));
        const y = numberFns.limitDecimals(Number(result.collisionPoint.y));
        const timeDifferenceToPoint = numberFns.formatHours(Number(result.timeDifferenceToPoint));
        const timeUntilCollision = numberFns.formatHours(Number(result.timeUntilCollision));

        logger.info(
            `Aviões "${a}" e "${b}": vão passar a ${timeDifferenceToPoint} de diferença no ponto (${x}, ${y}) daqui ${timeUntilCollision}`,
        );
    }
}
