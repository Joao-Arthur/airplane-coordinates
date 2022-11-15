import { backend } from '../../../backend/backend';
import { rotateAirplaneCoordinatesParamsType } from './rotateAirplaneCoordinatesParams';

export async function rotateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    angle,
    centerOfRotation,
}: rotateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length)
        return logger.warn('É necessário selecionar ao menos um avião!');
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const result = await backend.rotate({
            point: airplane.planePoint,
            angle,
            centerOfRotation,
        });
        airplaneRepository.update({ ...airplane, planePoint: result.point });
    }
    logger.success('Rotação realizada com sucesso!');
}
