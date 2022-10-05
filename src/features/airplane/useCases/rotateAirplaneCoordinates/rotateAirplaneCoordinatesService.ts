import { savedAirplaneToDTO } from '../savedAirplaneToDTO';
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
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const updatedAirplane = rotateAirplaneCoordinatesBusiness({
            airplane,
            angle,
            centerOfRotationX,
            centerOfRotationY,
        });
        airplaneRepository.update(dtoToSavedAirplane(updatedAirplane, airplane.type));
    }
    logger.success('Rotação realizada com sucesso!');
}
