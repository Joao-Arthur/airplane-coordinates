import { planeType } from '../../../backend/models/planeType';
import { translate } from '../../../backend/useCases/translate';
import { dtoToSavedAirplane } from '../dtoToSavedAirplane/dtoToSavedAirplane';
import { savedAirplaneToDTO } from '../savedAirplaneToDTO';
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
        const updatedAirplaneBackend = translate({
            point: {
                plane_type: airplane.type,
                a: airplane.a,
                b: airplane.b,
            },
            factor: {
                x: String(x),
                y: String(y),
            },
        });
        const updatedAirplane = translateAirplaneCoordinatesBusiness({
            airplane,
            x,
            y,
        });
        console.log({
            updatedAirplaneBackend,
            updatedAirplane,
        });
        airplaneRepository.update(dtoToSavedAirplane(updatedAirplane, airplane.type));
    }
    logger.success('Transformação realizada com sucesso!');
}
