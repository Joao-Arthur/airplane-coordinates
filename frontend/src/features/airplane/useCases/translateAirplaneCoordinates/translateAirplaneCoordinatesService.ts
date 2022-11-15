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
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const result = await backend.translate({
            point: airplane.planePoint,
            factor,
        });
        airplaneRepository.update({ ...airplane, planePoint: result.point });
    }
    logger.success('Transformação realizada com sucesso!');
}
