import { backend } from '../../../backend/backend';
import { scalonateAirplaneCoordinatesParamsType } from './scalonateAirplaneCoordinatesParams';

export async function scalonateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    factor,
}: scalonateAirplaneCoordinatesParamsType) {
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
    logger.success('Escalonamento realizado com sucesso!');
}
