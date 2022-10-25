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
        const newCoordinates = rotateAirplaneCoordinatesBusiness({
            coordinates: airplane,
            centerOfRotation: {
                x: String(centerOfRotationX),
                y: String(centerOfRotationY),
            },
            angle,
        });
        airplaneRepository.update({ ...airplane, ...newCoordinates });
    }
    logger.success('Rotação realizada com sucesso!');
}
