import { standardize } from '../standardize';
import { scalonateAirplaneCoordinatesBusiness } from './scalonateAirplaneCoordinatesBusiness';
import { scalonateAirplaneCoordinatesParamsType } from './scalonateAirplaneCoordinatesParams';

export function scalonateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: scalonateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .map(standardize)
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const updatedAirplane = scalonateAirplaneCoordinatesBusiness({
            airplane,
            x,
            y,
        });
        airplaneRepository.update(updatedAirplane);
    }
    logger.success('Escalonamento realizado com sucesso!');
}
