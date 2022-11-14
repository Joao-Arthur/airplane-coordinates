import { postFetch } from '../../../../core/httpRequest/httpRequest';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';
import { translateAirplaneCoordinatesParamsType } from './translateAirplaneCoordinatesParams';

export function translateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: translateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length)
        return logger.warn('É necessário selecionar ao menos um avião!');
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        postFetch('arithmetic/translate', {
            point: {
                planeType: airplane.planePoint.planeType,
                a: airplane.planePoint.a.toString(),
                b: airplane.planePoint.b.toString(),
            },
            factor: {
                x: x.toString(),
                y: y.toString(),
            },
        });
        const updatedAirplane = translateAirplaneCoordinatesBusiness({
            airplane,
            x,
            y,
        });
        airplaneRepository.update(updatedAirplane);
    }
    logger.success('Transformação realizada com sucesso!');
}
