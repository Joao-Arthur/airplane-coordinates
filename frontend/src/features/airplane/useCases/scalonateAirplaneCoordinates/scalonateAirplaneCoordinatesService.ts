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
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const newCoordinates = scalonateAirplaneCoordinatesBusiness({
            coordinates: airplane,
            x,
            y,
        });
        airplaneRepository.update({ ...airplane, ...newCoordinates });
    }
    logger.success('Escalonamento realizado com sucesso!');
}
