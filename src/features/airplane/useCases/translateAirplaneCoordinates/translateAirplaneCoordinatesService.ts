import { standardize } from '../standardize';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';
import { translateAirplaneCoordinatesParamsType } from './translateAirplaneCoordinatesParams';

export function translateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: translateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .map(standardize)
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const updatedAirplane = translateAirplaneCoordinatesBusiness({
            airplane,
            x,
            y,
        });
        airplaneRepository.update(updatedAirplane);
    }
    logger.success('Transformação realizada com sucesso!');
}
