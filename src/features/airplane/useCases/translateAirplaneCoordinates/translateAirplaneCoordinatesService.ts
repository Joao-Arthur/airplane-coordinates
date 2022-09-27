import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';
import { translateAirplaneCoordinatesParamsType } from './translateAirplaneCoordinatesParams';

export function translateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: translateAirplaneCoordinatesParamsType) {
    logger.info('Aplicando transformação de coordenadas');
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = translateAirplaneCoordinatesBusiness({ airplanes, x, y });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Transformação realizada com sucesso!');
}
