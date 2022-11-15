import { backend } from '../../../backend/backend';
import { scalonateAirplaneCoordinatesParamsType } from './scalonateAirplaneCoordinatesParams';

export async function scalonateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: scalonateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length)
        return logger.warn('É necessário selecionar ao menos um avião!');
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const result = await backend.scalonate({
            point: airplane.planePoint,
            factor: { x, y },
        });
        airplaneRepository.update({ ...airplane, planePoint: result.point });
    }
    logger.success('Escalonamento realizado com sucesso!');
}
