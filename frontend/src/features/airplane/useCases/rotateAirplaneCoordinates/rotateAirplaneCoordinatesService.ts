import { backend } from '../../../backend/backend';
import { rotateAirplaneCoordinatesParamsType } from './rotateAirplaneCoordinatesParams';

export async function rotateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    angle,
    centerOfRotation,
}: rotateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length)
        return logger.warn('É necessário selecionar ao menos um avião!');
    const points = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id))
        .map(({ id, point }) => ({ id, point }));
    const result = await backend.rotate({
        points,
        angle,
        centerOfRotation,
    });
    result.points.forEach(({ id, point }) => {
        airplaneRepository.updatePointById(id, point);
    });
    logger.success('Rotação realizada com sucesso!');
}
