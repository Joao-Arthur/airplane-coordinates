import { deleteAirplaneBusiness } from './deleteAirplaneBusiness';
import { deleteAirplaneParamsType } from './deleteAirplaneParams';

export function deleteAirplaneService({
    logger,
    airplaneRepository,
    selectedIds,
}: deleteAirplaneParamsType) {
    const airplanes = airplaneRepository.retrieve();
    if (!selectedIds.length) {
        logger.warn('É necessário selecionar ao menos um avião!');
        return;
    }
    try {
        for (const id of selectedIds) {
            deleteAirplaneBusiness({ airplanes, airplaneToDelete: id });
            airplaneRepository.remove(id);
        }
    } catch (error) {
        if (error instanceof Error)
            logger.error(error.message);
    }
}
