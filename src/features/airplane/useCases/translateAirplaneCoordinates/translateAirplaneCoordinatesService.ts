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
        const updatedAirplane = translateAirplaneCoordinatesBusiness({
            airplane,
            x,
            y,
        });
        airplaneRepository.update(dtoToSavedAirplane(updatedAirplane, airplane.type));
    }
    logger.success('Transformação realizada com sucesso!');
}
