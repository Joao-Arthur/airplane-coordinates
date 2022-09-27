import { rotateAirplaneCoordinatesBusiness } from './rotateAirplaneCoordinatesBusiness';
import { rotateAirplaneCoordinatesParamsType } from './rotateAirplaneCoordinatesParams';

export function rotateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: rotateAirplaneCoordinatesParamsType) {
    logger.info('Aplicando rotação de coordenadas');
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = rotateAirplaneCoordinatesBusiness({
        airplanes,
        angle,
        centerOfRotationX,
        centerOfRotationY
    });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Rotação realizada com sucesso!');
}
