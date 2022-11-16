import { backend } from '../../../backend/backend';
import { translateAirplaneCoordinatesParamsType } from './translateAirplaneCoordinatesParams';

export async function translateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    factor,
}: translateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length)
        return logger.warn('É necessário selecionar ao menos um avião!');
    const points = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id))
        .map(({ id, point }) => ({ id, point }));
    const result = await backend.scalonate({
        points,
        factor,
    });
    result.points.forEach(({ id, point }) => {
        airplaneRepository.updatePointById(id, point);
    });
    logger.success('Transformação realizada com sucesso!');
}
