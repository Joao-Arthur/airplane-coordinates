import { dtoToSavedAirplane } from '../dtoToSavedAirplane';
import { savedAirplaneToDTO } from '../savedAirplaneToDTO';
import { scalonateAirplaneCoordinatesBusiness } from './scalonateAirplaneCoordinatesBusiness';
import { scalonateAirplaneCoordinatesParamsType } from './scalonateAirplaneCoordinatesParams';

export function scalonateAirplaneCoordinatesService({
    logger,
    airplaneRepository,
    selectedIds,
    x,
    y,
}: scalonateAirplaneCoordinatesParamsType) {
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    const airplanes = airplaneRepository
        .retrieve()
        .filter(({ id }) => selectedIds.includes(id));
    for (const airplane of airplanes) {
        const updatedAirplane = scalonateAirplaneCoordinatesBusiness({
            airplane: savedAirplaneToDTO(airplane),
            x,
            y,
        });
        airplaneRepository.update(
            dtoToSavedAirplane(updatedAirplane, airplane.planePoint.type),
        );
    }
    logger.success('Escalonamento realizado com sucesso!');
}
