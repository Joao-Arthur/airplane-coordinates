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
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const newCoordinates = translateAirplaneCoordinatesBusiness({
            coordinates: airplane,
            x,
            y,
        });
        airplaneRepository.update({ ...airplane, ...newCoordinates });
    }
    logger.success('Transformação realizada com sucesso!');
}
