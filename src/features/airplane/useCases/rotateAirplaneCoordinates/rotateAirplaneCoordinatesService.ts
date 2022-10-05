import { standardize } from '../standardize';
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
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .map(standardize)
        .filter(({ id }) => selectedIds.includes(id));
    const updatedAirplanes = rotateAirplaneCoordinatesBusiness({
        airplanes,
        angle,
        centerOfRotationX,
        centerOfRotationY,
    });
    for (const airplane of updatedAirplanes)
        airplaneRepository.update(airplane);
    logger.success('Rotação realizada com sucesso!');
}
